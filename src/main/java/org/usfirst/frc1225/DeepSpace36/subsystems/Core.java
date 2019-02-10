package org.usfirst.frc1225.DeepSpace36.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Core extends Subsystem {
    private Compressor compressor1;
    private PowerDistributionPanel powerDistributionPanel1;
    private AnalogInput pressureGauge;

    public Core() {
        compressor1 = new Compressor(0);
        addChild("Compressor 1",compressor1);
        
        powerDistributionPanel1 = new PowerDistributionPanel(0);
        addChild("PowerDistributionPanel 1",powerDistributionPanel1);
        
        pressureGauge = new AnalogInput(1);
        addChild("PressureGauge",pressureGauge);
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {

    }
}

