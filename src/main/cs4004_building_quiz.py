# -------------------------
def new_meeting():

    guesses = []
    correct_guesses = 0
    question_num = 1

    for key in questions:
        print("-------------------------")
        print(key)
        for i in options[question_num-1]:
            print(i)
        guess = input("Enter (A, B, C, or D): ")
        guess = guess.upper()
        guesses.append(guess)

        correct_guesses += check_answer( guess)
        question_num += 1

    display_score( guesses)

# -------------------------
def check_answer( guess):

    if guess == guess:
        print("Your meeting results!")
        return 1


# -------------------------
def display_score(Results):
    print("-------------------------")
    print("RESULTS")
    print("-------------------------")

    print("Results: ", end="")
    for i in Results:
        print(i, end=" ")
    print()


# -------------------------
def choose_again():

    response = input("Do you want to choose again? (yes or no): ")
    response = response.upper()

    if response == "YES":
        return True
    else:
        return False
# -------------------------


questions = {
 "What building is your meeting in?: ": "A",
 "What floor is your meeting on?: ": "B",
 "What room have you booked?: ": "C",
 "What meeting type is the meeting? : ": "A"
}

options = [["A. Building_A", "B. Building_B", "C. Building_C", "D. Building_D"],
          ["A. Ground floor", "B. 1st Floor", "C. 2nd floor", "D. Top Floor"],
          ["A. Room A", "B. Room B", "C. Room C", "D. Room D"],
          ["A. Single level meeting","B. Multi level meeting", "C. professional meeting", "D. private meeting"]]

new_meeting()

while choose_again():
    new_meeting()

print("Have a nice meeting!")

# -------------------------
