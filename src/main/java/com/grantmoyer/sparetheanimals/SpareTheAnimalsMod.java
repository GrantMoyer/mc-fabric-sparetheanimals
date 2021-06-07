package com.grantmoyer.sparetheanimals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("sparetheanimals")
public class SpareTheAnimalsMod
{
    //private static final Logger LOGGER = LogManager.getLogger();

    public SpareTheAnimalsMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

//    @SubscribeEvent
//    public void onServerStarting(FMLServerStartingEvent event) {
//        
//    }
}
