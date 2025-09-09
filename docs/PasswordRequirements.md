## Title
Add Password Validation Logic

## Description
Implement validation logic for passwords in the user object. The validation should enforce the following rules:

- Password must be **at least 5 characters** long.
- Password must be **no more than 20 characters** long.
- Password must include **at least one uppercase letter**, **at least one lowercase letter**, and **at least one symbol**.
- Password may contain **only alphanumeric characters** and the following symbols: `@`, `$`, `%`, `&`, `#`.

## Acceptance Criteria
- [ ] Passwords shorter than 5 characters are rejected with an appropriate error message.
- [ ] Passwords longer than 20 characters are rejected with an appropriate error message.
- [ ] Passwords missing an uppercase letter are rejected with an appropriate error message.
- [ ] Passwords missing a lowercase letter are rejected with an appropriate error message.
- [ ] Passwords missing a symbol (`@`, `$`, `%`, `&`, `#`) are rejected with an appropriate error message.
- [ ] Passwords containing characters outside the allowed set are rejected with an appropriate error message.