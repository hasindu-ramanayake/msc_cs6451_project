package org.example.core;

import org.example.customer.CustomerMgr;
import org.example.rental.RentalMgr;
import org.example.session.SessionMgr;
import org.example.core.MgrT;
import org.example.vehicle.VehicleMgr;

import java.util.HashMap;

public class JCRMain implements ISingleton{
    private static ISingleton jcrMgr;
    private HashMap<MgrT, ISingleton> mgrMap;

    public static ISingleton getInstance() {
        if ( jcrMgr == null) {
            jcrMgr = new JCRMain();
        }
        return jcrMgr;
    }
    private JCRMain() {
        System.out.println("DEBUG: CREATE JCR MGR OBJECT: ");
        mgrMap = new HashMap<>();
        this.initMgrClasses();
    }

    private void initMgrClasses() {
        this.mgrMap.put(MgrT.VEHICLE_MGR, VehicleMgr.getInstance());
        this.mgrMap.put(MgrT.SESSION_MGR, SessionMgr.getInstance());
        this.mgrMap.put(MgrT.CUSTOMER_MGR, CustomerMgr.getInstance());
        this.mgrMap.put(MgrT.RENTAL_MGR, RentalMgr.getInstance());
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE JCR MGR OBJECT: ");

    }

    public ISingleton getMgrInstance(MgrT type){
        return mgrMap.get(type);
    }


}
