
# Automated-SMS-Motivator

Spring Boot program using the Twilio API to send motivational SMS messages whenever I procrastinate.
## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Set up your Twilio account by visiting [Twilio's website](https://www.twilio.com/try-twilio) and signing up.
4. Obtain your Twilio account SID, auth token, and trial number from the Twilio console.
5. Update the `application.yaml` file with your Twilio credentials.
6. Build the project using Maven.
7. Run the application.

## Usage

Once the application is running, you can send SMS messages by making POST requests to the `/sms/send` endpoint with the following JSON payload:

```
{
  "phoneNumber": "RECIPIENT_PHONE_NUMBER",
  "message": "YOUR_MESSAGE"
}
```

Replace `RECIPIENT_PHONE_NUMBER` with the recipient's phone number and `YOUR_MESSAGE` with the message you want to send.

## Configuration

The application uses Twilio for sending SMS messages. You need to provide your Twilio credentials in the `application.properties` file:

```
twilio:
accountSid=YOUR_ACCOUNT_SID
authToken=YOUR_AUTH_TOKEN
trialNumber=YOUR_TRIAL_NUMBER
```

Replace `YOUR_ACCOUNT_SID`, `YOUR_AUTH_TOKEN`, and `YOUR_TRIAL_NUMBER` with your actual Twilio credentials.

## Dependencies

This project depends on the following libraries:

- Spring Boot
- Twilio Java SDK
- Google's libphonenumber
- Spring Web
- Validation (Bean I/O with Hibernate Validator)

These dependencies are managed via Maven.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.
