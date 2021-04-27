# Roomie

Projeto Perfil Engenharia de Aplicações

## Low-Fidelity Prototype

To access the prototype:

-   inspect [prototype folder](prototype) to see its static representation with images
-   interact with the dynamic prototype, [here](https://www.figma.com/proto/QI3glrnfyr5FPTlQFCQNmb/Prototype?node-id=10%3A1356&scaling=min-zoom&page-id=2%3A1302).

## Backend

### Prerequisites

The following software is required to be installed on your system:

-   JDK 11+
-   PostgreSQL

### How to Run

#### Create Database and User

```bash
sudo -u postgres psql
postgres=# create database roomie;
postgres=# create user roomie with encrypted password 'passw0rd';
postgres=# grant all privileges on database roomie to roomie;
```

#### Add orm.jar dependency

```bash
mvn install:install-file -Dfile=./lib/orm.jar -DgroupId=org.orm -DartifactId=orm -Dversion=1.0 -Dpackaging=jar
```

#### Run Project

Execute (in IntelliJ) by running `RestApiApplication.java` file.

#### Create DB Schema

Execute endpoint http://localhost:8083/api/admin/create-db.

## Deployment

### How to Run

#### Prerequisites

-   [Ansible](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html)
-   [Python 3](https://www.python.org/downloads)
-   [pip3](https://pip.pypa.io/en/stable/installing/)
-   Google Cloud Service Account (in JSON format), with permissions to manage networking interfaces and Cloud Compute VMs (a disabled example is provided)

#### Installation

```bash
pip3 install requests google-auth
ansible-galaxy collection install google.cloud
ansible-galaxy collection install ansible.posix
ansible-galaxy collection install community.docker
```

#### Execution

-   To run a full provisioning (which creates all VMs, then installs all of the required components on them):

    ```bash
    ANSIBLE_CONFIG=ansible.cfg ansible-playbook playbook.yml --tags "create-vms,provision"
    ```

-   To delete the VMs (and, by extension, terminate the deployment):

    ```bash
    ANSIBLE_CONFIG=ansible.cfg ansible-playbook playbook.yml --tags "delete-vms"
    ```

-   To scale up or down a service:

    -   Available services:

        -   frontend - default of 3 replicas
        -   backend - default of 3 replicas

    -   Examples:
        ```bash
        ANSIBLE_CONFIG=ansible.cfg ansible-playbook -i hosts.gcp.yml scale.yml -e "frontend=3"
        ANSIBLE_CONFIG=ansible.cfg ansible-playbook -i hosts.gcp.yml scale.yml -e "frontend=3 backend=1"
        ```

### Orchestration

The orchestration tool used in this assignment is [Docker Swarm](https://docs.docker.com/get-started/swarm-deploy). This phase of deployment is the result of improving the work described in the [Intermediate Installation section](#intermediate-installation).

### Provisiong

This deployment uses [Ansible](https://www.ansible.com) to automate provisioning and configuration of the application on [Google Cloud Platform](https://cloud.google.com).

## Authors

-   **Diogo Ribeiro:** [ribeiropdiogo](https://github.com/ribeiropdiogo)
-   **José Diogo Monteiro:** [dxmonteiro](https://github.com/DxMonteiro)
-   **João Nuno Abreu:** [JoaoNunoAbreu](https://github.com/JoaoNunoAbreu)
-   **Rui Mendes:** [ruimendes29](https://github.com/ruimendes29)
-   **Vasco Ramos:** [vascoalramos](https://vascoalramos.me)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
