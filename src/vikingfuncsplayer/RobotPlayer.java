package vikingfuncsplayer;

import battlecode.common.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public strictfp class RobotPlayer {

    public static Random random = null;
    
    public static void run(RobotController rc) throws GameActionException {
        while(true){
            try{
                trySpawn(rc);
                if(rc.isSpawned()) {
                    int round = rc.getRoundNum();
                    if(round <= GameConstants.SETUP_ROUNDS) Setup.runSetup(rc);
                    else MainPhase.runMainPhase(rc);
                }
            }
        }
    }

    private static void trySpawn(RobotController rc) throws GameActionException {
        MapLocation[] locations = rc.getAllySpawnLocations();
        for(MapLocation loc : locations) {
            if(rc.canSpawn(loc)) {
                rc.spawn(loc);
                break;
            }
        }
    }
   
}
