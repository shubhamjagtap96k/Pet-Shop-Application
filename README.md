# Pet Shop Management System - Backend API

A comprehensive Spring Boot REST API for managing a pet shop business, including pets, customers, employees, suppliers, transactions, and various services.

## Features

- **Pet Management**: CRUD operations for pets with categories, breeds, and pricing
- **Customer Management**: Customer registration and profile management
- **Employee Management**: Staff information and role management
- **Supplier Management**: Supplier contact and relationship tracking
- **Transaction Tracking**: Sales and payment processing
- **Service Management**: Grooming services and vaccination records
- **Inventory Management**: Pet food and supplies tracking

## Technology Stack

- **Framework**: Spring Boot 3.2.0
- **Database**: MySQL (primary), H2 (testing)
- **ORM**: Spring Data JPA with Hibernate
- **Security**: Spring Security
- **Validation**: Bean Validation (Jakarta Validation)
- **Mapping**: MapStruct
- **Build Tool**: Maven
- **Java Version**: 17+

## Project Structure

```
src/main/java/com/petshop/
├── controller/          # REST controllers
├── service/            # Business logic services
├── repository/         # Data access layer
├── entity/             # JPA entities
├── dto/                # Data transfer objects
├── mapper/             # MapStruct mappers
├── exception/          # Custom exceptions and handlers
├── config/             # Configuration classes
└── PetShopApplication.java
```

## Database Schema

The application implements the following main entities:
- **Address**: Physical addresses for customers, employees, suppliers
- **Pet**: Pet information with categories and pricing
- **Customer**: Customer profiles and contact information
- **Employee**: Staff information and roles
- **Supplier**: Vendor information and contacts
- **Transaction**: Sales and payment records
- **PetCategory**: Pet classification system
- **PetFood**: Inventory management for pet food
- **GroomingService**: Available grooming services
- **Vaccination**: Vaccination types and records

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+ (for production)
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd petshop-backend
```

### 2. Database Setup

#### Option A: MySQL (Production)
1. Install MySQL and create a database:
```sql
CREATE DATABASE petshop_db;
```

2. Update `application.yml` with your MySQL credentials:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/petshop_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
    username: your_username
    password: your_password
```

#### Option B: H2 (Development/Testing)
Run with the `dev` profile to use H2 in-memory database:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

### 3. Build and Run

#### Using Maven
```bash
# Install dependencies
mvn clean install

# Run the application
mvn spring-boot:run
```

#### Using IDE
1. Import the project as a Maven project
2. Run the `PetShopApplication.java` main class

### 4. Verify Installation
The application will start on `http://localhost:8080`

API base URL: `http://localhost:8080/api/v1`

## API Endpoints

### Pet Management
- `GET /api/v1/pets` - Get all pets
- `GET /api/v1/pets/{id}` - Get pet by ID
- `POST /api/v1/pets` - Create new pet
- `PUT /api/v1/pets/{id}` - Update pet
- `DELETE /api/v1/pets/{id}` - Delete pet
- `GET /api/v1/pets/category/{categoryId}` - Get pets by category
- `GET /api/v1/pets/breed/{breed}` - Get pets by breed
- `GET /api/v1/pets/price-range?minPrice={min}&maxPrice={max}` - Get pets by price range
- `GET /api/v1/pets/search?name={name}` - Search pets by name

### Customer Management
- `GET /api/v1/customers` - Get all customers
- `GET /api/v1/customers/{id}` - Get customer by ID
- `POST /api/v1/customers` - Create new customer
- `PUT /api/v1/customers/{id}` - Update customer
- `DELETE /api/v1/customers/{id}` - Delete customer
- `GET /api/v1/customers/search?name={name}` - Search customers by name
- `GET /api/v1/customers/email/{email}` - Get customer by email

### Transaction Management
- `GET /api/v1/transactions` - Get all transactions
- `GET /api/v1/transactions/{id}` - Get transaction by ID
- `GET /api/v1/transactions/customer/{customerId}` - Get transactions by customer
- `GET /api/v1/transactions/pet/{petId}` - Get transactions by pet

### Category Management
- `GET /api/v1/categories` - Get all categories
- `GET /api/v1/categories/{id}` - Get category by ID
- `POST /api/v1/categories` - Create new category
- `PUT /api/v1/categories/{id}` - Update category
- `DELETE /api/v1/categories/{id}` - Delete category

## Sample API Requests

### Create a Pet
```bash
curl -X POST http://localhost:8080/api/v1/pets \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Buddy",
    "breed": "Golden Retriever",
    "age": 2,
    "price": 1200.00,
    "description": "Friendly and energetic dog",
    "imageUrl": "https://example.com/buddy.jpg",
    "categoryId": 1
  }'
```

### Create a Customer
```bash
curl -X POST http://localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@email.com",
    "phoneNumber": "555-0101",
    "addressId": 1
  }'
```

### Get All Pets
```bash
curl http://localhost:8080/api/v1/pets
```

## Testing

### H2 Console (Development Mode)
When running with the `dev` profile, you can access the H2 database console at:
`http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (leave empty)

### Sample Data
The application loads sample data automatically when using H2 database, including:
- 3 addresses
- 5 pet categories (Dogs, Cats, Birds, Fish, Reptiles)
- 3 customers
- 3 employees
- 2 suppliers
- 4 pets
- Pet food items
- Grooming services
- Vaccination types

## Configuration

### Application Properties
Key configuration options in `application.yml`:

```yaml
server:
  port: 8080
  servlet:
    context-path: /api/v1

spring:
  jpa:
    hibernate:
      ddl-auto: update    # Creates/updates tables automatically
    show-sql: true        # Shows SQL queries in logs
  
  jackson:
    serialization:
      write-dates-as-timestamps: false
```

### Profiles
- **default**: Uses MySQL database
- **dev**: Uses H2 in-memory database for development

## Error Handling

The application includes comprehensive error handling:
- **404 Not Found**: When resources don't exist
- **400 Bad Request**: For validation errors
- **500 Internal Server Error**: For unexpected errors

All errors return structured JSON responses:
```json
{
  "status": 404,
  "error": "Resource Not Found",
  "message": "Pet not found with id: 999",
  "timestamp": "2024-01-15T10:30:00"
}
```

## Security

Currently configured for development with:
- CORS enabled for all origins
- CSRF disabled
- All endpoints publicly accessible

For production, implement:
- JWT authentication
- Role-based access control
- API rate limiting
- Input sanitization

## Development Tips

1. **Adding New Entities**: Follow the established pattern:
   - Create entity class in `entity` package
   - Add repository interface in `repository` package
   - Create DTO in `dto` package
   - Add mapper interface in `mapper` package
   - Implement service in `service` package
   - Create controller in `controller` package

2. **Database Changes**: 
   - Modify entity classes
   - Set `ddl-auto: update` for automatic schema updates
   - Or use Flyway/Liquibase for production migrations

3. **Testing**: 
   - Use H2 for integration tests
   - MockMvc for controller testing
   - TestContainers for database integration tests

## Troubleshooting

### Common Issues

1. **Port 8080 already in use**:
   ```bash
   # Change port in application.yml or run with different port
   mvn spring-boot:run -Dserver.port=8081
   ```

2. **Database connection failed**:
   - Verify MySQL is running
   - Check database credentials in `application.yml`
   - Ensure database exists

3. **Build failures**:
   ```bash
   # Clean and rebuild
   mvn clean install -U
   ```

## Future Enhancements

- [ ] JWT Authentication & Authorization
- [ ] File upload for pet images
- [ ] Email notifications
- [ ] Inventory management
- [ ] Reporting and analytics
- [ ] Payment gateway integration
- [ ] Appointment scheduling system
- [ ] Real-time notifications

