package com.phantommentalists.steamworks.component;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("38bc95f2-27cd-419f-bb2d-8b152ecc87e9")
public class DriveSide {
    @objid ("b625a7b8-f142-4190-9273-e48cafc6251d")
    private CANTalon masterMotor;

    @objid ("ec8d5611-6730-499c-b1fd-02cc18877a77")
    private CANTalon followerMotor;

    @objid ("6bf0ea78-47be-4842-a005-e90a57b4407b")
    private Wheel frontWheel;

    @objid ("2ba11a31-ab1e-43e2-ae46-26b179e6db9c")
    private Wheel rearWheel;

}
