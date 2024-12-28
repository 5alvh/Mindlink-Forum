# Forum Module - Version 1.0.0

## Overview
This is the initial release of the **Forum Module** for our application. The module allows users to interact through posts, comments, and likes. It also provides the foundational CRUD functionalities for user management and forum interactions. The data flow and design emphasize clean architecture, encapsulation, and adherence to best practices.

---

## Features
### User Management
- 👤 Basic CRUD operations for users.

### Post Management
- 📝 Create, read, update, and delete posts.
- Posts are associated with users.

### Comment Management
- 💬 Add comments to posts.
- Update and delete comments.

### Like Management (Coming Soon)
- 👍 Likes for posts and comments will be managed in an upcoming update.

---

## Architecture
The module follows a layered architecture to separate concerns and ensure scalability.

### Layers:
1. **Models:** Represent the core entities in the system.
   - `User` (temporary, for testing purposes)
   - `Post`
   - `Comment`
   - `Like`

2. **DTOs (Data Transfer Objects):**
   - For each model, there are `CreateDTO`, `GetDTO`, and `UpdateDTO` classes.
   - Ensure only essential and non-sensitive information is transferred between layers.

3. **Mappers:**
   - Located in the `utils` package.
   - Convert models to DTOs and vice versa.
   - Prevent exposure of sensitive information.

4. **Repositories:**
   - CRUD operations for each model.
   - Acts as the data access layer.

5. **Services and Service Implementations:**
   - Encapsulate business logic.
   - Methods for handling user, post, and comment operations.
   - Modularized to allow seamless addition of future functionalities (e.g., likes).

6. **Controllers:**
   - REST APIs for interacting with the forum module.
   - User-friendly endpoints to manage users, posts, and comments.
   - Controllers for "likes" will be included in the next update.

---

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/forum-module.git
   ```
2. Navigate to the project directory:
   ```bash
   cd forum-module
   ```
3. Build and run the application using your preferred IDE or build tool (e.g., Maven, Gradle).
4. Access the REST API documentation (if integrated with Swagger or similar tools).

---

## Endpoints
Below is a summary of the available endpoints:

### User Endpoints 👤
- **GET** `/users` (or `/users/all`): Get all users.
- **POST** `/users/`: Create a new user.
- **PUT** `/users/{id}`: Update user details.
- **DELETE** `/users/{id}`: Delete a user.

### Post Endpoints 📝
- **GET** `/posts/`: Get all posts.
- **POST** `/posts/`: Create a new post.
- **GET** `/posts/{id}`: Get a post by ID.
- **PUT** `/posts/{postId}`: Update a post.
- **DELETE** `/posts/{postId}`: Delete a post.

### Comment Endpoints 💬
- **GET** `/comment/`: Get all comments.
- **POST** `/comment/`: Add a comment to a post.
- **GET** `/comment/{id}`: Get a comment by ID.
- **PUT** `/comment/{id}`: Update a comment.
- **DELETE** `/comment/{id}`: Delete a comment.

### Like Endpoints 👍 (Coming Soon)

---

## Known Issues
- The "likes" feature is not yet implemented.
- User model is a temporary placeholder and may be extended in future updates.

---

## Future Enhancements
- Complete the implementation of the "likes" feature.
- Enhance user authentication and role-based access control.
- Improve documentation with examples and Swagger integration.
- Optimize database queries for scalability.

---

## Contributing
We welcome contributions to improve the Forum Module! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes.
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push the branch.
   ```bash
   git push origin feature-name
   ```
5. Open a pull request on GitHub.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contact
For questions or feedback, feel free to reach out:
- 📧 Email: salahidslhddnn@gmail.com / idslhddnn@gmail.com
- 💻 GitHub: [5alvh](https://github.com/5alvh)

---

Thank you for exploring the Forum Module! Stay tuned for future updates.

