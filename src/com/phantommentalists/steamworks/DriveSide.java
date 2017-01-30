package com.phantommentalists.steamworks;

import com.ctre.CANTalon;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("38bc95f2-27cd-419f-bb2d-8b152ecc87e9")
public class DriveSide {
    @objid ("48fa25fe-65df-4a9c-8ad6-2fae4e1d4bda")
    private CANTalon masterMotor;

    @objid ("3507f6e7-e0dd-4fff-bb23-93a8003f5272")
    private CANTalon followerMotor;

    @objid ("6bf0ea78-47be-4842-a005-e90a57b4407b")
    private Wheel frontWheel;

    @objid ("2ba11a31-ab1e-43e2-ae46-26b179e6db9c")
    private Wheel rearWheel;

}
