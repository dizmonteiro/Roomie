from locust import HttpUser, task, between

class MyUser(HttpUser):
    wait_time = between(1, 2)

    @task
    def index(self):
        headers = {'content-type': 'application/json'}
        payload = {'email':'test@test.com', 'password':'test'}
        response = self.client.post("/api/auth/login", json=payload, headers=headers)