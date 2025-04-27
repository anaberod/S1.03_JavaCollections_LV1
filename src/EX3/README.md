# 📄 Description - Exercise Statement

Given the file `countries.txt` (see the resources section), which contains countries and their capitals, the program must read the file and store the data into a `HashMap<String, String>`.  
The program must ask for the user's name, and then randomly show a country stored in the `HashMap`.  
The user must type the name of the capital of the shown country. If the answer is correct, the user earns one point.  
This action is repeated 10 times. After asking for the capitals of 10 random countries, the program must save the user's name and their score into a file called `classificacio.txt`.

# 💻 Technologies Used

Java 17  
IntelliJ IDEA

# 📋 Requirements

Java Development Kit (JDK) 17 or higher  
IntelliJ IDEA or another compatible Java IDE

# 🛠️ Installation

Clone the repository:

```bash
git clone https://github.com/anaberod/S1.03_JavaCollections_LV1.git
```

Navigate to the project directory:

```bash
cd Month-Exercise
```

Open the project in IntelliJ IDEA.  
Build the project if necessary.

# ▶️ Execution

Open the project in IntelliJ IDEA.  
Locate the `Main` class containing the `main` method.  
Run the `Main` class.  
The program will prompt for the user's name and then start the quiz by randomly selecting 10 countries.  
After answering, the user's name and score will be saved in the `classificacio.txt` file.

# 🌐 Deployment

No deployment is necessary for this educational exercise.  
Optionally, you can package it as a `.jar` file using Maven:

```bash
mvn package
```

# 🤝 Contributions

Fork the repository.  
Create a new branch:

```bash
git checkout -b feature/NewFeature
```

Make your changes and commit them:

```bash
git commit -m "Add New Feature"
```

Push your changes:

```bash
git push origin feature/NewFeature
```

Open a pull request.
