from locust import between


class UserSimulationConfig:
    wait_time_between_tasks = between(5, 25)