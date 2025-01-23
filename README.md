# Refugees Management System

## Overview
The **Refugees Management System** is a comprehensive platform designed to manage and streamline aid distribution for refugees across various countries. The system organizes refugees based on their country of origin, providing insights into their living conditions and enabling efficient resource allocation. Key features include displaying country-specific data, searching for specific countries, managing donor information, and viewing refugee details. Additionally, an admin login grants access to advanced functionalities for system management.

## Features
- **Display Countries**: View a list of countries and their associated refugee data.
- **Search for a Country**: Search for a specific country and display its refugee information.
- **Display Donors**: View a list of donors and their contributions.
- **Display Refugees**: View detailed information about refugees in a specific country.
- **Admin Login**: Log in as an admin to access additional functionalities such as adding/removing refugees, managing donors, and distributing aid.
- **Distribute Aid**: Distribute donations to refugees based on their needs.
- **Add/Remove Refugees**: Add new refugees or remove existing ones from the system.
- **Add Donors**: Add new donors and their contributions to the system.
- **Delete Countries**: Remove countries and their associated refugee data from the system.

## Data Structures Used
- **Linked List**: Used to manage lists of refugees, donors, and countries.
- **Queue**: Used to manage refugees and donations in a priority-based manner.
- **Node**: A generic class used to create nodes for linked lists and queues.

## Classes Overview
- **Admin**: Manages admin login and verification.
- **Person**: A superclass for `Refugee` and `Donor`, containing common properties like name, age, and nationality.
- **Refugee**: Represents a refugee, including properties like donation needed, country, number of children, and description.
- **Donor**: Represents a donor, including properties like donated amount.
- **Donation**: Represents a donation made by a donor.
- **Node**: A generic class representing a node in a linked list or queue.
- **LinkedList**: A generic class representing a linked list, used to manage refugees, donors, and countries.
- **RefugeesQueue**: Manages a queue of refugees, allowing for priority-based aid distribution.
- **DonationQueue**: Manages a queue of donations.
- **CountriesList**: Manages a list of countries and their associated refugee queues.

## How to Use
1. **Run the Program**: Execute the `Main` class to start the system.
2. **Main Menu**: The system will display a menu with options to display countries, search for a country, display donors, display refugees, log in as an admin, or exit the program.
3. **Admin Login**: To access advanced functionalities, log in as an admin using the credentials:
   - **Username**: `MohamadDana`
   - **Password**: `md2023`
4. **Admin Menu**: Once logged in, you can add/remove refugees, add donors, distribute aid, and more.

## Example Use Cases
- **Display Countries**: View a list of all countries and their associated refugee data.
- **Search for a Country**: Search for a specific country and view its refugee information.
- **Add a Refugee**: Add a new refugee to a specific country.
- **Add a Donor**: Add a new donor and their contribution to the system.
- **Distribute Aid**: Distribute donations to refugees in a specific country based on their needs.
- **Delete a Refugee**: Remove a refugee from the system.
- **Delete a Country**: Remove a country and its associated refugee data from the system.

## Conclusion
The **Refugees Management System** is a robust and reliable tool for managing refugees and donations efficiently. Its intuitive design and extensive functionalities make it a valuable asset for organizations and individuals involved in refugee assistance efforts.

## Installation
1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE (e.g., IntelliJ, Eclipse).
3. Compile and run the `Main` class to start the system.

## Dependencies
- **Java SE Development Kit (JDK)**: Ensure you have JDK installed on your system.
- **Scanner Class**: Used for user input.
