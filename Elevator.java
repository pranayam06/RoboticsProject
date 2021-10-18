package com.company;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Elevator extends SubsystemBase {
    private final VictorSP motorController1 = new VictorSP(1);
    private final VictorSP motorController2 = new VictorSP(2);
    private final SpeedControllerGroup motors = new SpeedControllerGroup(motorController1, motorController2);

    // constructor
    public Elevator() {
        motorController1.setVoltage(12.00);
        motorController2.setVoltage(12.00);
    }

    public void elevatorUp(){
        motors.set(1);
    }

    public void elevatorDown(){
        motors.set(-1);
    }

    public void elevatorStop() { motors.set(0); }

}
