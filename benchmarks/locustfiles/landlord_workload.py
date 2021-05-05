from locust import HttpUser, task
from config import UserSimulationConfig

# 1 -> register
# 2 -> login
# 3 -> add house(s)
# 4 -> list its houses
# 5 -> check applications
# 6 -> see tenant profile (fixed tenant)


class LandlordWorkload(HttpUser):
    wait_time = UserSimulationConfig.wait_time_between_tasks

    user = None
    token = None
    houses = []

    def on_start(self):
        self.register()
        self.login()
        print(self.user)
        print(self.token)

    @task
    def simulate(self):
        pass

    def register(self):
        payload = {
            "email": "ld@test5.com",
            "password": "test",
            "username": "ld",
            "name": "Vasco Ramos",
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
        payload = {"email": "ld@test5.com", "password": "test"}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)
        self.token = response.json()["token"]

    def post_house(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        self.client.post("/api/auth/login", json=payload, headers=headers)

    def get_houses(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        self.client.post("/api/auth/login", json=payload, headers=headers)

    def get_applications(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        self.client.post("/api/auth/login", json=payload, headers=headers)

    def get_tenant_profile(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        self.client.post("/api/auth/login", json=payload, headers=headers)