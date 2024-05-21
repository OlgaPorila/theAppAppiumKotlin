### Test Approach Rationale

#### Rationale

1. **Modular Design**:
    - **Separation of Concerns**: By separating page object
      classes (`LandingPage`, `LeaguesPage`, `TeamsPage`, `BasePage`, `MainPage`) and test classes, we ensure that each
      class has a single responsibility. This makes the code more maintainable and easier to understand.
    - **Reusability**: Page object methods encapsulate interactions with the app, allowing these methods to be reused
      across multiple tests.

2. **JUnit 5 for Test Execution**:
    - **Annotations**: Using JUnit 5 annotations (`@BeforeEach`, `@ParameterizedTest`, `@MethodSource`, `@Test`)
      provides a structured and clean way to set up and run tests.
    - **Lifecycle Management**: The `@BeforeEach` method ensures that the setup is done before each test, which is
      crucial for maintaining a clean state across tests.

3. **Kotlin for Test Implementation**:
    - **Conciseness**: Kotlin's syntax is concise and expressive, reducing boilerplate code.
    - **Null Safety**: Kotlin's type system helps avoid null pointer exceptions, making the tests more robust.

4. **Appium for UI Testing**:
    - **Cross-Platform**: Appium supports multiple platforms (iOS, Android), making it suitable for testing mobile
      applications.
    - **Flexibility**: Using Appium allows us to write tests in Kotlin, leveraging the same language across different
      layers of the test framework.

5. **RESTAssured for API Testing**:
    - **Simplicity**: RESTAssured provides a simple syntax for writing API tests, making it easy to validate RESTful web
      services.
    - **Integration**: API tests can be integrated with the UI tests to perform end-to-end testing, ensuring that the
      backend services are working correctly in conjunction with the mobile app.

6. **Parameterized Tests**:
    - **Efficiency**: Parameterized tests allow us to run the same test with different inputs, increasing test coverage
      without duplicating code.
    - **Flexibility**: Using `@MethodSource` to provide test data makes it easy to extend tests with new data sets.

### Coverage Assessment

1. **UI Testing Coverage**:
    - **Navigation Flows**: Tests like `testLeaguesFlow` and `testTeamsFlow` cover critical navigation flows within the
      application. These tests ensure that users can navigate through different sections (e.g., leagues, teams) without
      issues.
    - **User Interactions**: Verifying elements such as page titles, headers, and tabs ensures that the app's UI
      components behave as expected when interacted with by the user.

2. **API Testing Coverage**:
    - **Endpoint Validation**: Using RESTAssured, we validate key API endpoints that the app relies on. This ensures
      that the app's interactions with the backend are functioning correctly.
    - **Data Consistency**: API tests help ensure that the data displayed in the app is consistent with the data
      provided by the backend services.

3. **Parameterized Tests Coverage**:
    - **Multiple Scenarios**: Parameterized tests allow us to cover multiple scenarios and data sets, ensuring robust
      testing across different inputs and conditions.
    - **Edge Cases**: We can easily add edge cases to parameterized tests to ensure the app handles unusual or extreme
      inputs gracefully.

4. **Combined Coverage**:
    - **End-to-End Scenarios**: By combining UI and API tests, we achieve comprehensive coverage of end-to-end
      scenarios. This ensures that both the frontend and backend components work together seamlessly.
    - **Error Handling and Edge Cases**: Tests can be extended to cover error handling and edge cases, such as network
      failures or invalid input, to ensure that the app handles these scenarios gracefully.

### Explanation:

1. **Parameterized Tests**:
    - **`spotlightsTest`**: This test uses parameterized inputs for different API URIs and their corresponding expected
      values.
    - **`testTeamsFlow`**: This test also uses parameterized inputs to verify the teams flow with different favorite
      league and team combinations.

2. **Data Provider**:
    - **`provideTestData`**: Provides a stream of arguments for the parameterized tests. Each `Arguments.of` represents
      a test case with its expected API URI and Android URL.

3. **Set Up Method**:
    - The `setUp` method initializes the WebDriver and page objects before each test, ensuring a clean state for each
      test run.

### Conclusion

The test approach is designed to be modular, maintainable, and comprehensive. By leveraging JUnit 5, Kotlin, Appium,
RESTAssured, and parameterized tests, we achieve a robust test framework that covers critical UI and API interactions.
This approach ensures high-quality coverage of the application's core features and provides a solid foundation for
future test expansion.
By using parameterized tests, we efficiently cover multiple scenarios, enhancing our test coverage and ensuring the
application's robustness across various inputs.