package com.company;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.I2C.Port;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.Timer;


public class ColorSensor extends SubsystemBase {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch colorMatcher = new ColorMatch();


    public String getColor(){
        final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
        final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
        final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
        final Color recievedColor = colorSensor.getColor();
        final ColorMatchResult match = colorMatcher.matchClosestColor(recievedColor);

        String color;
        if (match.color == kGreenTarget) {
            color = "green";
        }
        else if (match.color == kRedTarget){
            color = "red";
        }
        else if (match.color == kYellowTarget){
            color = "yellow";
        }
        else {
            color = "red";
        }

        return color;
    }

    @Override
    public void periodic(){
        if( getColor() == "green" ){
            // method to move drivetrain straight
        }
        else if (getColor() == "red"){
            // method to stop drivetrain motors
        }
        else if (getColor() == "yellow") {
            // method to stop drivetrain motors
            Timer.delay(5.00);
            // method to start drivetrain motors

        }

    }

}
