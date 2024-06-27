# Carousell News

CarousellNews is an application developed using Kotlin that provides a Carousell News designed using Clean Architecture principles. The home page contains list of News.

## Tech stack & Open-source libraries
1. **Clean Architecture**
   Create a separation of concern between layers into presentation, domain, and data for a modular and scalable codebase.
   - **Presentation Layer**: Contains UI components and presentation logic.
   - **Domain Layer**: Defines use cases and business logic independent of UI.
   - **Data Layer**: Manages data sources, repositories, and external services.

2. **MVVM**
   - Architecture pattern used to create a separation of concern between Model, View, and ViewModel.

3. **Navigation Jetpack**
   - Simplifies the implementation of navigation between screen (in this case fragments) in the app.

4. **ViewModel**
   - UI related data holder, lifecycle aware.

5. **Lifecycles**
   - Create a UI that automatically responds to lifecycle events.

6. **LiveData**
   - Build data objects that notify views when the underlying database changes.

7. **Hilt**
   - for dependency injection.

8. **Kotlin Coroutines**
   - for managing background threads with simplified code and reducing needs for callbacks.

9. **Glide**
   - for image loading.

10. **Retrofit2 & OkHttp3**
   - to make REST requests to the web service integrated.

11. **Unit Test**
   - for unit testing view model.