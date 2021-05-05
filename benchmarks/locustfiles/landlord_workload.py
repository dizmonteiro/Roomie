from locust import HttpUser, task
from config import UserSimulationConfig
from faker import Faker

# 1 -> register
# 2 -> login
# 3 -> add house(s)
# 4 -> list its houses
# 5 -> check applications
# 6 -> see tenant profile (fixed tenant)

fake = Faker()


class LandlordWorkload(HttpUser):
    wait_time = UserSimulationConfig.wait_time_between_tasks

    user = None
    token = None

    def on_start(self):
        self.register()
        self.login()
        for _i in range(0, 4):
            self.post_house()
        self.get_houses()
        self.get_applications()
        self.get_tenant_profile()

    @task
    def simulate(self):
        pass

    def register(self):
        profile = fake.simple_profile()
        payload = {
            "email": "a" + str(fake.random_int(0, 100)) + profile["mail"],
            "password": fake.password(),
            "username": profile["username"],
            "name": profile["name"],
            "birthDate": "2021-04-14",
            "sex": "male",
            "nif": "111111111",
            "address": "Av 1 B1 2E, Viseu",
            "phone": "9111111111",
        }
        response = self.client.post(
            "/api/landlords", data=payload, files={"foo": "bar"}
        )
        self.user = payload
        self.user["id"] = response.json()["id"]

    def login(self):
        headers = {"content-type": "application/json"}
        payload = {"email": self.user["email"], "password": self.user["password"]}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)
        self.token = response.json()["token"]

    def post_house(self):
        headers = {"Authorization": "Bearer " + self.token}
        payload = {
            "title": fake.text(),
            "rooms": fake.random_int(0, 100),
            "availableRooms": fake.random_int(0, 100),
            "bathRooms": fake.random_int(0, 100),
            "minPrice": "250",
            "maxPrice": "300",
            "description": fake.text(),
            "features": "feat1,feat2,feat3",
            "address": fake.address(),
        }
        self.client.post(
            "/api/houses", data=payload, files={"foo": "bar"}, headers=headers
        )

    def get_houses(self):
        headers = {"Authorization": "Bearer " + self.token}
        self.client.get("/api/houses?limit=30", headers=headers)

    def get_applications(self):
        headers = {"Authorization": "Bearer " + self.token}
        self.client.get(
            f"/api/landlords/{self.user['id']}/applications",
            headers=headers,
            name="/api/landlords/[id]/applications",
        )

    def get_tenant_profile(self):
        headers = {"Authorization": "Bearer " + self.token}
        self.client.get("/api/tenants/1", headers=headers)