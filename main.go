package main

import (
	"fmt"
	"log"
	"net/smtp"
)

func main() {
	from := "ernando@localhost.com"
	to := []string{"receiver@localhost.com"}

	message := []byte(
		"From: " + from + "\r\n" +
			"To: " + to[0] + "\r\n" +
			"Subject: Test of email sending\r\n" +
			"\r\n" +
			"Test Message with mailhog.",
	)

	auth := smtp.PlainAuth("", "", "", "localhost")
	err := smtp.SendMail("localhost:1025", auth, from, to, message)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println("Email sent successfuly")
}
