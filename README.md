# Roomie

Projeto Perfil Engenharia de Aplicações

## Low-Fidelity Prototype

To access the prototype:

-   inspect [prototype folder](prototype) to see its static representation with images
-   interact with the dynamic prototype, [here](https://www.figma.com/proto/QI3glrnfyr5FPTlQFCQNmb/Prototype?node-id=10%3A1356&scaling=min-zoom&page-id=2%3A1302).


## Backend

### Prerequisites
The following software is required to be installed on your system:
- JDK 11+
- PostgreSQL

### How to Run

#### Create Database and User
```bash
sudo -u postgres psql
postgres=# create database roomie;
postgres=# create user roomie with encrypted password 'passw0rd';
postgres=# grant all privileges on database roomie to roomie;
```

#### Run Project
Execute (in IntelliJ) by running `RestApiApplication.java` file.

#### Create DB Schema
Execute endpoint http://localhost:8083/api/admin/create-db.


## Authors

-   **Diogo Ribeiro:** [ribeiropdiogo](https://github.com/ribeiropdiogo)
-   **José Diogo Monteiro:** [dxmonteiro](https://github.com/DxMonteiro)
-   **João Nuno Abreu:** [JoaoNunoAbreu](https://github.com/JoaoNunoAbreu)
-   **Rui Mendes:** [ruimendes29](https://github.com/ruimendes29)
-   **Vasco Ramos:** [vascoalramos](https://vascoalramos.me)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
