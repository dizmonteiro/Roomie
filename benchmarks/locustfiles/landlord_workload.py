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

    def on_start(self):
        self.client.get("https://github.com/")

    @task
    def simulate(self):
        pass

    @task
    def index(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)