from locust import HttpUser, task
from config import UserSimulationConfig
from faker import Faker

import random

# 1 -> register
# 2 -> login
# 3 -> search for houses
# 4 -> apply to house(s)
# 5 -> get applications
# 6 -> remove one application

fake = Faker()


class TenantWorkload(HttpUser):
    wait_time = UserSimulationConfig.wait_time_between_tasks

    user = None
    token = None
    houses = []
    applications = []

    def on_start(self):
        self.register()
        self.login()
        self.get_houses()
        for _i in range(0, random.randint(3, 7)):
            self.apply_to_house()
        self.get_applications()
        self.cancel_application()

    @task
    def simulate(self):
        pass

    def register(self):
        profile = fake.simple_profile()
        payload = {
            "email": "b" + str(fake.random_int(0, 100)) + profile["mail"],
            "password": fake.password(),
            "username": profile["username"],
            "name": profile["name"],
            "birthDate": "2021-04-14",
            "sex": "male",
            "nif": "111111111",
            "nationality": "PT",
            "occupation": "Test occupation",
            "phone": "9111111111",
        }
        response = self.client.post("/api/tenants", data=payload, files={"foo": "bar"})
        self.user = payload
        self.user["id"] = response.json()["id"]

    def login(self):
        headers = {"content-type": "application/json"}
        payload = {"email": self.user["email"], "password": self.user["password"]}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)
        self.token = response.json()["token"]

    def get_houses(self):
        headers = {"Authorization": "Bearer " + self.token}
        response = self.client.get(
            "/api/houses?limit=60&offset=" + str(fake.random_int(0, 100)),
            headers=headers,
            name="/api/houses?limit=[number]&offset=[number]",
        )
        self.houses = response.json()

    def apply_to_house(self):
        headers = {
            "content-type": "application/json",
            "Authorization": "Bearer " + self.token,
        }
        payload = {
            "houseId": random.choice(self.houses)["id"],
        }
        response = self.client.post(
            "/api/applications", json=payload, headers=headers, catch_response=True
        )
        if (
            response.status_code == 400
            and response.json()["message"] == "Tenant already applied to this house."
        ):
            response.success()

    def get_applications(self):
        headers = {"Authorization": "Bearer " + self.token}
        response = self.client.get(
            f"/api/tenants/{self.user['id']}/applications",
            headers=headers,
            name="/api/tenants/[id]/applications",
        )
        self.applications = response.json()

    def cancel_application(self):
        headers = {
            "Authorization": "Bearer " + self.token,
        }
        houseId = random.choice(self.applications)["house"]["id"]
        self.client.delete(
            f"/api/applications/{houseId}",
            headers=headers,
            name="/api/applications/[id]",
        )
