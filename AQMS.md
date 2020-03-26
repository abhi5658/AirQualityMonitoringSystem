## Air Quality Monitoring System

### Backend: Spring boot 

### Database: PostgreSQL(hosted on AWS) 

### Hosted on: originally AWS 

### Dashboard : HTML, CSS, bootstrap, Charts(fusion charts) 

### Implementation:  

- Designed pages in JSP for dynamic content. 
- Direct sign up on the website through email. 
- Auth maintained across various screen using session 
- Developed backend in MVC architecture.  
- Data is provided using input screen to enter pollutant levels during a  day in any specific region. 
- The pollutant levels are then used  to calculate AQI(Air Quality Index) by the backend service. 
- A cron job runs to notify harmful levels of AQI to the user. 
- Admin panel to watch/view on various levels of AQI in historical view using graphs in specific regions. 
- Notifications to admins when AQI gets beyond certain limit for any region 

### Difficulties: 
- To continuously look for abnormal  AQIs consumed resources, hence implemented cron job to check for it every day 2 times 
- Authentication was lost in initial application, hence implemented session through all screens
- Dependency management through Maven
