package algonquin.cst2335.li000848;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 ** This class is  the main activity class and  checks if a password meets complexity criteria.
 *  * Users input a password, and it's evaluated for specific requirements.
 *
 * @author JingYi
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    /**
     * This line declares a private member variable textView of  TextView and initializes it to null.
     */
    private TextView tv = null;
    /**
     * This line declares a private member variable editText of  EditText and initializes it to null.
     */
    private EditText et = null;
    /**
     *  This line declares a private member variable button of  Button and initializes it to null
     */
    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        et = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();

            boolean passwordRequirements = checkPasswordComplexity(password);

            if (passwordRequirements) {
                tv.setText("Your password is complex enough");
            } else {
                tv.setText("You shall not pass");
            }
        });

    }

    /**
     * This function determines whether a password meets the required password criteria or not , if it is a strong password , return true and vice versa
     *
     * @param password The string  which  we are checking
     * @return  true if password is complex and meets the password requirements and false if the password is not complex and does not meet the requirement
     */

    private boolean checkPasswordComplexity(String password) {

        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;

        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
// looping through the password using for each loop
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            } else if (isSpecialCharacter(c)) {
                foundSpecial = true;
            }

        }
// checking  if any of the criteria for the password whether it is upper cas or lower case or found a number or has a special symbol is not met
        if (!foundUpperCase) {
            showToast("Your password does not have an upper case letter");
            return false;
        } else if (!foundLowerCase) {
            showToast("Your password does not have a lower case letter");
            return false;
        } else if (!foundNumber) {
            showToast("Your password does not have a number");
            return false;
        } else if (!foundSpecial) {
            showToast("Your password does not have a special symbol");
            return false;
        }
//        if all the criteria is true
        return true;
    }

    /**
     * this function displays the toast message
     * @param message the message to be shown in the toast message
     */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * This function  checks if a character is a special symbol.
     * @param c the character that has been checked
     * @return true if  the character is a special symbol and false if not a special symbol
     */

    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
            case '$':
            case '%':
            case '^':
            case '&':
            case '*':
            case '!':
            case '@':
            case '?':
                return true;
            default:
                return false;
        }
    }

}