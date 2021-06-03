from faker import Faker

import os, random, requests, json

fake = Faker()

BASE_URL = "http://35.205.162.29:8083/api"


def register_landlord():
    profile = fake.simple_profile()
    payload = {
        "email": "l_" + str(fake.random_int(0, 100)) + profile["mail"],
        "password": fake.password(),
        "username": profile["username"],
        "name": profile["name"],
        "birthDate": "2021-04-14",
        "sex": "male",
        "nif": "111111111",
        "address": "Av Test B1 2E, Viseu",
        "phone": "9111111111",
    }
    response = requests.post(
        f"{BASE_URL}/landlords",
        data=payload,
        files={
            "file": open("./avatars/" + random.choice(os.listdir("./avatars")), "rb")
        },
    )
    payload["id"] = response.json()["id"]
    return payload


def register_tenant():
    profile = fake.simple_profile()
    payload = {
        "email": "t_" + str(fake.random_int(0, 100)) + profile["mail"],
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
    response = requests.post(
        f"{BASE_URL}/tenants",
        data=payload,
        files={
            "file": open("./avatars/" + random.choice(os.listdir("./avatars")), "rb")
        },
    )
    payload["id"] = response.json()["id"]
    return payload


def login(email, password):
    headers = {"content-type": "application/json"}
    payload = {"email": email, "password": password}
    response = requests.post(f"{BASE_URL}/auth/login", json=payload, headers=headers)
    return response.json()["token"]


def post_house(token):
    headers = {"Authorization": "Bearer " + token}
    payload = {
        "title": fake.text(),
        "rooms": fake.random_int(0, 6),
        "availableRooms": fake.random_int(0, 5),
        "bathRooms": fake.random_int(0, 3),
        "minPrice": 250,
        "maxPrice": 300,
        "description": fake.text(max_nb_chars=500).replace("\n", " "),
        "features": "feat1,feat2,feat3,feat4",
        "address": "Av Test B1 2E, Viseu",
    }

    files = []
    for _i in range(0, random.randint(1, 7)):
        files.append(
            ("files", open("./houses/" + random.choice(os.listdir("./houses")), "rb"))
        )

    response = requests.post(
        f"{BASE_URL}/houses",
        data=payload,
        files=files,
        headers=headers,
    )
    return response.json()


def main():
    landlords = []
    tenants = []
    houses = []

    for _i in range(0, 50):
        landlord = register_landlord()
        landlord["token"] = login(landlord["email"], landlord["password"])
        landlords.append(landlord)

    for _i in range(0, 50):
        tenant = register_tenant()
        tenant["token"] = login(tenant["email"], tenant["password"])
        tenants.append(tenant)

    for _i in range(0, 500):
        landlord = random.choice(landlords)
        house = post_house(landlord["token"])
        houses.append(house)

    users = {"landlords": landlords, "tenants": tenants}
    with open("./users.json", "w") as file:
        json.dump(users, file, indent=4, sort_keys=True)


if __name__ == "__main__":
    main()
