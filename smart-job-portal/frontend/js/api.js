const BASE_URL = "http://localhost:8080";

const API = {

    // AUTH

    register: BASE_URL + "/api/auth/register",

    login: BASE_URL + "/api/auth/login",


    // STUDENT PROFILE

    studentProfile: BASE_URL + "/student/profile",


    // COMPANY PROFILE

    companyProfile: BASE_URL + "/company",


    // JOBS

    getAllJobs: BASE_URL + "/job/jobs",

    studentJobs: BASE_URL + "/job/student/jobs",

    getJob: BASE_URL + "/job",

    createJob: BASE_URL + "/job",

    updateJob: BASE_URL + "/job",

    deleteJob: BASE_URL + "/job",

    searchByTitle: BASE_URL + "/job/search/title",

    searchByLocation: BASE_URL + "/job/search/location",

    searchByExperience: BASE_URL + "/job/search/experience",

    searchBySkills: BASE_URL + "/job/search/skills",

    jobPagination: BASE_URL + "/job/page",

    sortSalary: BASE_URL + "/job/sort/salary",

    companyJobs: BASE_URL + "/job/company",

    companyApplications: BASE_URL + "/application/job",


    // APPLICATION

    applyJob: BASE_URL + "/application/apply",

    studentApplications: BASE_URL + "/application",

    updateApplicationStatus: BASE_URL + "/application",

    deleteApplication: BASE_URL + "/application",


    // DASHBOARD

    adminDashboard: BASE_URL + "/admin/dashboard",

    studentDashboard: BASE_URL + "/student/dashboard",

    companyDashboard: BASE_URL + "/company/dashboard",

    // Admin

    adminUsers: BASE_URL + "/admin/users",

    adminCompanies: BASE_URL + "/admin/companies",

    adminJobs: BASE_URL + "/admin/jobs",

    adminApplications: BASE_URL + "/admin/applications",

    deleteApplicationAdmin: BASE_URL + "/admin/application",

    deleteUser: BASE_URL + "/admin/user",

    deleteCompany: BASE_URL + "/admin/company",

    deleteJobAdmin: BASE_URL + "/admin/job"

    
};