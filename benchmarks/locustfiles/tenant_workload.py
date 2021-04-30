from locust import HttpUser, task
from config import UserSimulationConfig


class TenantWorkload(HttpUser):
    wait_time = UserSimulationConfig.wait_time_between_tasks

    @task
    def index(self):
        headers = {"content-type": "application/json"}
        payload = {"email": "test@test.com", "password": "test"}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)