# TDD Junior Skills Session Demo

This repository provides the structure for a simple demonstration of Test-Driven Development (TDD) principles using Java. This repository has been designed to accompany an introductory session on TDD.

The repository includes a `User` class and a set of validation requirements for Usernames and Passwords. 

## Using This Repository

If you need some help setting up the project, please refer to the [Step-by-Step Project Setup Instructions](docs/setup_instructions/ProjectSetupInstructions.md) or the [Project Setup AI Prompt](docs/setup_instructions/ProjectSetupAIPrompt.md).

The goal of this repository is to practice TDD principles by implementing validation logic for usernames and passwords based on the provided requirements.

Requirements for Username and Password validation are provided in separate markdown files: 
- [Username Requirements](docs/UsernameRequirements.md)
- [Password Requirements](docs/PasswordRequirements.md)

Tests should be written first (in the `UserTest` class) to cover the validation rules, followed by the implementation of the validation logic in the `User` class.

### TDD Overview
For those new to TDD, the basic cycle is Red-Green-Refactor:

#### Red
- **Write a Test**: Start by writing a test for a new feature or functionality.
- **Run the Test**: Run the test to see it fail (since the feature is not yet implemented).
#### Green
- **Write Code**: Write the minimum amount of code necessary to make the test pass.
- **Run Tests Again**: Run all tests to ensure the new test passes and no other tests are broken.
#### Refactor
- **Refactor the Implementation**: Clean up the code while ensuring all tests still pass.
- **Repeat**: Continue this cycle for each new feature. 

## Branches
- `main`: The main branch contains everything that you need to try out some Test-Driven Development.
- `Completed_Tests_and_Imp`: This branch contains a completed version of the UserTest class and an implementation the User class. You can use this branch to compare your work or if you get stuck!
- `Completed_Tests`: This branch contains a completed version of the UserTest class with some example tests implemented. 
- `Password_Tests`: This branch contains tests for Password validation. This branch is used for demonstration purposes during the session.

### Branch Naming

Any additional branches will be named with a preceding capitalised keyword to indicate their purpose:
e.g. `ADD_New_Tests`, `CHANGE_ReadMe_File`

## Changes

### Major Change Log
- [16-09-2025] Added Step-by-Step and AI Prompt Setup Instructions.
- [11-09-2025] Repository first made public.

