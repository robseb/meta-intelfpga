# Guide how to update the BusyBox default configuration file

1. Chnage the BusyBox Configuration with `menuconfig` and save it
1. The configuration file is written to a location as follows: `~/poky/build/tmp/work/cortexa9hf-neon-poky-linux-gnueabi/busybox/1.31.1-r0/busybox-1.31.1/`
1. Start the Yocto Project Environment script (`~/poky`)
1. Create the `busybox_%` script file
    ````cmd
    recipetool appendsrcfile -w /home/vm/poky/meta-intelfpga busybox ~/poky/build/tmp/work/cortexa9hf-neon-poky-linux-gnueabi/busybox/1.31.1-r0/busybox-1.31.1//rsyocto_default_busyBox_1.31.1.conf
    ````
    *  Syntax 
        ````
        recipetool appendsrcfile -w [dir to destination meta-layer to] [recipe] [File location to include]
        ````
    * A new script file will be created `meta-intelfpga/recipes-core/busybox/busybox_%.bbappend` 