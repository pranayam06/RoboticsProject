package com.company;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class Conveyor extends SubsystemBase {
    private final WPI_VictorSPX conveyorMotor1 = new WPI_VictorSPX();
    private final WPI_VictorSPX conveyorMotor2 = new WPI_VictorSPX();

    private final SpeedControllerGroup conveyorMotors = new SpeedControllerGroup(conveyorMotor1, conveyorMotor2);

    public Conveyor() {
        conveyorMotor1.configVoltageCompSaturation(12);
        conveyorMotor1.enableVoltageCompensation(true);

        conveyorMotor2.configVoltageCompSaturation(12);
        conveyorMotor2.enableVoltageCompensation(true);
    }

    public void conveyorIn() {
        conveyorMotors.set(-1);
    }

    public void stopConveyor() {
        conveyorMotors.stopMotor();
    }

}
