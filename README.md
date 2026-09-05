# Smart Job Portal

A full-stack web application that connects applicants, companies, and administrators through a centralized job portal. The platform enables companies to post and manage jobs, applicants to search and apply for opportunities, and administrators to manage users, companies, jobs, and applications.

## 🌐 Live Demo

🔗 **[Open Smart Job Portal](https://smart-job-portal-frontend-one.vercel.app/)**

##  About the Project

Smart Job Portal is a role-based job management platform designed to simplify the job search and recruitment process.

The application supports three different user roles:

- 👤 Applicant
- 🏢 Company
- 👨‍💼 Admin

Each role has its own dashboard and dedicated functionalities. Applicants can search and apply for jobs, companies can post and manage job listings, and administrators can monitor and manage the overall platform.

The application uses JWT authentication and Spring Security to provide secure, role-based access control.

## Features

### Authentication & Security

- User registration and login
- JWT-based authentication
- Password encryption using BCrypt
- Role-based authorization using Spring Security
- Protected API endpoints

### Applicant Features

- Manage applicant profile
- View available job opportunities
- Search jobs by title
- Search jobs by location
- Search jobs by experience
- Search jobs by skills
- Job pagination
- View detailed job information
- Apply for jobs
- Track submitted applications

### Company Features

- Manage company profile
- Company dashboard
- Create job postings
- Update job postings
- Delete job postings
- View posted jobs
- View applications received for jobs
- Manage application status

### Admin Features

- Admin dashboard
- View registered users
- View companies
- View all jobs
- View job applications
- Manage platform data
- Delete users
- Delete companies
- Delete jobs
- Delete applications

## Tech Stack

### Frontend

- HTML5
- CSS3
- JavaScript
- Font Awesome

### Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

### Database

- MySQL
- Aiven Cloud MySQL

### Authentication

- JWT (JSON Web Token)
- BCrypt Password Encryption

### Deployment

- Frontend: Vercel
- Backend: Render
- Containerization: Docker
- Database: Aiven Cloud MySQL

### Development Tools

- VS Code
- Spring Tool Suite (STS)
- MySQL Workbench
- Postman
- Git & GitHub

## System Architecture

```text
                 ┌─────────────────────┐
                 │        Users        │
                 │                     │
                 │ Applicant | Company │
                 │        Admin        │
                 └──────────┬──────────┘
                            │
                            ▼
              ┌──────────────────────────┐
              │     Vercel Frontend      │
              │                          │
              │ HTML • CSS • JavaScript  │
              └────────────┬─────────────┘
                           │
                        REST API
                           │
                           ▼
              ┌──────────────────────────┐
              │     Render Backend       │
              │                          │
              │ Docker • Spring Boot     │
              │ Spring Security • JWT    │
              └────────────┬─────────────┘
                           │
                           ▼
              ┌──────────────────────────┐
              │    Aiven Cloud MySQL     │
              │        Database          │
              └──────────────────────────┘
```

## 🌍 Live Application

🔗 **Frontend:** [Smart Job Portal](https://smart-job-portal-frontend-one.vercel.app/)

🔗 **Backend API:** [Smart Job Portal API](https://smart-job-portal-api-mau9.onrender.com/)
