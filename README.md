![GitHub](https://img.shields.io/static/v1?label=Plattform&message=Intel+SoC-FPGA&color=blue)
![GitHub](https://img.shields.io/static/v1?label=Yocto+Project+Releases&messagescarthgap&color=darkgreen)
![GitHub](https://img.shields.io/github/license/robseb/meta-intelfpga)
<br>

# BSP meta-layer for Intel (*ALTERA*) SoC-FPGAs (*SoCFPGAs*) and the *Yocto Project* 

**With this layer the board support package (BSP) for *ARM* based *Intel (ALTERA) SoC-FPGAs (SoCFPGA)* is added to the *Yocto Project*.** <br>
**It can bring with the *rstools* useful tools to interact with the FPGA fabric (e.g. Changing the FPGA configuration or accessing all ARM AXI Bride interfaces).** <br>
**In addition, is the ARM Development Studio (*DS-5*) *Streamline* Server [*gator*](https://github.com/ARM-software/gator) included.**

Usually the *Yocto Project* can generate all required components (*rootfs*, *device tree*, bootloaders,...) to boot up a final embedded Linux. But this is not compatible with [Intel's Boot flow](https://www.intel.com/content/dam/www/programmable/us/en/pdfs/literature/an/an709.pdf).
This Bootflow uses the Intel *Embedded Design Suite* (*EDS*) to build the device tree and all necessary bootloaders. 

For that reason, I designed a version that is compatible with *Intel's* development tools.  
This includes the board specific *u-boot-* and device tree-generation and the support for only the *.tar.gz*-file type for the *rootfs*. 

I used this layer to build [*rsyocto*](https://github.com/robseb/rsyocto), an open source embedded Linux Distribution for Intel SoC-FPGAs, by myself. 
The flexibility of my own [**rsyocto build system**](https://github.com/robseb/rsyocto#build-system-for-generation-of-custom-rsyocto-flavors) allows you to use it for your own projects with your custom embedded Linux. 
 
For instance with a single Linux shell command (`FPGA-writeConfig`) of the *rstools* it is possible to change FPGA configuration of a Intel *Cyclone V SoC-FPGA*: <br>
![Alt text](doc/FPGAConfigurationAction.gif?raw=true "Write FPGA Configuration")

**More *rstools* examples are available [here inside my *rsyocto* guide](https://github.com/robseb/rsyocto/blob/rsyocto-1.042/doc/guides/2_FPGA_HARDIP.md#interacting-with-fpga-ip).**

**Note:** Right now only are the *rstools* for the Intel *Cyclone V*- and Intel *Arria 10 SX*- SoC-FPGA available. 


## Supported Device families

| **Device Family** | **Architecture** | **Machine Name** |
|:--|:--|:--|
| Intel (*ALTERA*) **Cylone V** SoC-FPGA | *ARMv7A* | *MACHINE ="cyclone5"* |
| Intel (*ALTERA*) **Arria 10** SoC-FPGA | *ARMv7A* | *MACHINE ="arria10"* |
<br>

## Linux Kernel Types

| **Linux Version Name** | **Version Type** | **Supported Linux Kernel Versions**  |
|:--|:--|:--|
| *"linux-altera"* | **Regular Linux Version** |`5.8`, `6.0`, `6.1`, `6.2`, `6.5`, `6.6`, `6.7` |
| *"linux-altera-lts"* | **Long term stable Linux Version (LTS)** | `5.4.54`,`5.10.60`,`5.10.100`, `5.15.70`, `5.15.80`, `5.15.90`, `5.15.100`, `6.1.20`, `6.1.38`, `6.1.55`, `6.1.68`|  

**The Linux Kernel source code is available on the official [Intel (*ALTERA*) repository](https://github.com/altera-opensource/linux-socfpga)**. 
<br>

## List of *rstools* to interact with the FPGA-fabric

| **Linux Command Name** | **Description** | **CV** | **A10**  | **Bitbake value**
|:--|:--|:--|:--|:--|
|`FPGA-status` | **Reading the Status of the FPGA fabric** | :heavy_check_mark: | :heavy_check_mark: | *statusfpga* 
|`FPGA-readMSEL` | **Reading the Configuration mode of the FPGA (selected with the MSEL-Bit Switch)** | :heavy_check_mark: | :heavy_check_mark: | *mselfpga*
|`FPGA-dumpbridge` | **Reading a address span from an address of an AXI Bridge interface or SDRAM** | :heavy_check_mark: | :x: | *dumpbridge* 
|`FPGA-resetFabric` | **Resetting the FPGA fabric (remove the FPGA running configuration)** | :heavy_check_mark: |:x: | *resetfabricfpga*
|`FPGA-writeConfig` | **Writing a new FPGA configuration with a configuration file** | :heavy_check_mark: |:x: | *writeconfigfpga*
|`FPGA-readBridge` | **Reading from an address of an AXI Bridge interface (*Lightweight HPS2FPGA* or *HPS2FPGA*) or form the *MPU* Address space** | :heavy_check_mark: | :heavy_check_mark: | *readbridgesfpga*
|`FPGA-writeBridge` | **Writing to an address of an AXI Bridge interface (*Lightweight HPS2FPGA* or *HPS2FPGA*) or form the *MPU* Address space** | :heavy_check_mark: | :heavy_check_mark:  | *writebridgefpga*
|`FPGA-gpiRead` | **Reading the 32 Bit direct access general purpose input Register (GPI) (written by the FPGA)** | :heavy_check_mark: |:x: | *readfgpipga*
|`FPGA-gpoWrite` | **Writing the 32 Bit direct access general purpose output Register (GPO)** | :heavy_check_mark: |:x:  | *writegpofpga*


The source code of the *rstools* is available here: [For the Intel Cyclone V SoC-FPGA](https://github.com/robseb/rstoolsCY5) and [For the Intel Arria 10 SoC-FPGA](https://github.com/robseb/rstoolsA10)
<br>

## List of available additional components 

| **Component Name** | **Description** | **Bitbake value**
|:--|:--|:--|
| `gator` | [**ARM Development Studio (*DS-5*) Streamline server**](https://github.com/ARM-software/gator) | *gator* 
| `initscript`| **Enables to execute various init scripts during Linux booting at different booting levels** | *initscript*
<br>

**A Linux Kernel Configuration with an appropriate configuration to enable all ARM Core-Sight Debugging features for ARM Streamline will be automatically loaded.**

## Choose your preferred ARM Development Studio (*DS-5*) Streamline server version
| **Gator Version** | **Compatible ARM Streamline Version** | **Expression**
|:--|:--|:--|
| `8.6.0` | `Streamline 8.6.0` | PREFERRED_VERSION:gator = "8.6.0"
| `8.0.0` | `Streamline 8.0.0` | PREFERRED_VERSION:gator = "8.0.0"
| `7.8.0` | `Streamline 7.8.0` | PREFERRED_VERSION:gator = "7.8.0"


## Tested Development Machine Setup

* **OS**
	* **Ubuntu 20.04 LTS**
	* **Ubuntu 24.04 LTS**

* **Yocto Project Releases**
	* **scarthgap** (*5.0*)

**Note:** Select the dedicated branch for the Yocto Project Release you want to use in this repository.

<br>

<br>

## Getting started with the *Yocto Project* and use of this BSP-layer

The following step by step guide shows how to use this layer to build a Yocto-based Linux System for an *Intel SoC-FPGA*:
1. Step: **Install the latest Version of the *OpenEmbedded Yocto Project***
	* As a Building machine use regular *Ubuntu-Linux* or **CentOS Linux** running as a *Virtual Machine* (VM)
	* Required components for the *Yocto Project* with **Ubuntu Linux**:
		````bash
		sudo apt-get -y install gawk wget libgmp3-dev libmpc-dev \
        git diffstat unzip texinfo gcc-multilib build-essential \
        chrpath socat xterm libsdl2-image-2.0-0 u-boot-tools \
        python3 python3-pip python3-pexpect \
        python3-git python3-jinja2 libncurses-dev zstd lz4
		````
	* Set local settings
		````bash
		sudo locale-gen en_US.UTF-8
		export LANG=en_US.UTF-8
		export LC_ALL=en_US.UTF-8
		````	
	* **Optional:** Ubuntu Linux for usage of the *Arm Development Studio (DS-5)*
		````bash
		sudo apt-get install libncurses5
		sudo apt-get install zlib1g:i386
		
		wget http://archive.ubuntu.com/ubuntu/pool/main/i/icu/libicu60_60.2-3ubuntu3_amd64.deb
		sudo apt install ./libicu60_60.2-3ubuntu3_amd64.deb
		
		wget http://de.archive.ubuntu.com/ubuntu/pool/universe/w/webkitgtk/libjavascriptcoregtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
		sudo apt install ./libjavascriptcoregtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
		
		wget http://security.ubuntu.com/ubuntu/pool/universe/w/webkitgtk/libwebkitgtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
		sudo apt install ./libwebkitgtk-1.0-0_2.4.11-3ubuntu3_amd64.deb
		
		sudo apt-get install -y libc6-armel-cross libc6-dev-armel-cross binutils-arm-linux-gnueabi libncurses5-dev build-essential bison flex libssl-dev bc
		
		sudo apt-get install -y gcc-arm-linux-gnueabihf g++-arm-linux-gnueabihf  gcc-arm-linux-gnueabi g++-arm-linux-gnueabi
		````
	* Check your git version (it should be 2.24+)
		````bash
		git --version
		````
	* Check your gcc version (it should be >13.2.0) 
		````bash
		gcc --version
		````

	* Install the *Yocto Project* itself in Release *5.0 "scarthgap"*
		````bash
		cd && git clone -b scarthgap git://git.yoctoproject.org/poky.git
		````
    * Install the *OpenEmbedded* SDK Standalone Version
        ````cmd
        cd ~/poky && wget https://downloads.yoctoproject.org/releases/yocto/yocto-5.0/buildtools/x86_64-buildtools-nativesdk-standalone-5.0.sh && sh x86_64-buildtools-nativesdk-standalone-5.0.sh
        ````
        * Run the SDK environment script as shown in the previous command, e.g.: 
            ````cmd
            source /opt/poky/5.0/environment-setup-x86_64-pokysdk-linux
            ````
2. Step: **Download this BSP-layer**
	````bash
	cd poky/ && git clone https://github.com/robseb/meta-intelfpga.git
	````

3. Step: **Run the *bitbake* initialization script**
	````bash 
	source oe-init-build-env
	````
	* Do not run this command or any other Yocto commands as root!
	* Do not use the command: “*sudo ./ oe-init-build-env*”. With this line Bitbake crashes later during the build process without any traceable error message  
	* The script should create the folder: "`/build`"

4. Step: **Add this BSP-layer to your Yocto Project solution**
	* Open the **"bblayers.conf"**-file *(poky/build/conf)* with a text editor for example with *MS Visual Studio Code*:
		````bash 
		code conf/bblayers.conf
		````
	* Add the following line to this file to include the BSP-layer:
		````bitbake
		/home/vm/poky/meta-intelfpga \
		````
		* **Note:** Replace the user name *"vm"* with your user name
	* Now should the *"bblayers.conf"*-file look like this:
		````bitbake
		# POKY_BBLAYERS_CONF_VERSION is increased each time build/conf/bblayers.conf
		# changes incompatibly
		POKY_BBLAYERS_CONF_VERSION = "2"

		BBPATH = "${TOPDIR}"
		BBFILES ?= ""
		BBLAYERS ?= " \
		  /home/vm/poky/meta \
		  /home/vm/poky/meta-poky \
		  /home/vm/poky/meta-yocto-bsp\
		  /home/vm/poky/meta-intelfpga \
		"
		````
5. Step: **Configure the machine type and Linux Version**
	* Open the **"local.conf"**-file *(poky/build/conf)* with a text editor, for example with *MS Visual Studio Code*:
		````bash 
		code conf/local.conf
		````
	* **Select your Intel SoC-FPGA family** by adding the value **"MACHINE"** to this configuration file
		* For the different devices use string of the table above
		* For example, for an Intel Cyclone V SoC-FPGA add following to this file:
			````bitbake
			MACHINE ="cyclone5"
			````
		* Be sure that default *"qwmux86-64"* is **removed**
			````bitbake
			# MACHINE ??= "qemux86-64"
			````
	* **Select the Linux Kernel type**
		* If you want to use the regular **ALTERA socfpga-Linux Kernel** add the line above to the **"local.conf"**-file:
			````bitbake
			PREFERRED_PROVIDER_virtual/kernel = "linux-altera"
			````
		* If you want the **long term stable (LTSI) ALTERA socfpga-Linux Kernel** use this line:
			````bitbake
			PREFERRED_PROVIDER_virtual/kernel = "linux-altera-lts"
			````
	* **Select the Linux Kernel Version**
	 	* With following code line it is possible to select the preferred Linux Kernel Version (here with *Version `6.1`*)
			````bibtabe
			PREFERRED_VERSION_linux-altera = "6.1%"
			````
		* Alternatively, to select the *Long term stable Linux Version* (*LTS*) `6.1.68` 
			````bibtabe
			PREFERRED_VERSION_linux-altera = "6.1.68%"

			````
		* All supported Linux Kernel versions are listed above
		* Add these two lines to the **"local.conf"**-file independent of your chosen machine 
 	* **Select the used CPU Version**
		* For an Dual Core Intel (ALTERA) **Cyclone V SoC-FPGA**, **Arria V SoC-FPGA** or **Arria 10 SoC-FPGA** add the following line to the **"local.conf"**-file:
		````bibtabe
		DEFAULTTUNE = "cortexa9hf-neon"
		````
		* This selects the ARMv7 Cortex-A9 dual core CPU with the NEON-Engine and a vector floating-point unit
	* **Save and close this file**
	
6. Step: **Check if your settings are vialed and executable**
	* The following shell-command lists all for this build used layers (executed inside *poky/build/*):
		````bibtabe
		bitbake-layers show-layers
		````
		* If an error occured certainly something with the "**local.conf**- or "**bblayers.conf"**-file went wrong
	* This command gives the used Linux Kernel Version
		````bibtabe
		bitbake --show-versions | grep linux  
		````
7. Step: **Optional: Change the Linux Kernel configuration**
	* To configure the Linux properly for a specific device family it is necessary to change the Linux Kernel configuration
	* But for a first *Yocto Project* build is the Linux Kernel configured well enough
	* Read and change the BSP-layer with **"defcongig"**
		* One part is configured by a "*defconfig*-file"
		* With that it is possible to enable or disabled every component, like for example ETHERNET, CAN, EXT2, HPS-Bridges and PCI
		* The following bitbake shell-command stores the "*defconfig*-file locally (executed inside *poky/build/*)
		````bash
		bitbake -c savedefconfig virtual/kernel 
		````
		* This command prints the directory of the saved file at the end
	* Read and change the Linux Kernel with **menueconfig**
		* Use this command to start the "*menueconfiguration*"-tool:
		````bash
		bitbake -c menuconfig -f virtual/kernel
		````
		* A window like this should appear: 
		![Alt text](doc/LinuxKerneMenueConfigl.jpg?raw=true "Linux Kernel menu Config")

		<br>

		* Here it is possible to change any kernel settings, ARM-Platform specific settings or enable or disable some peripherel components
        * The *menueconfig* configuration will be stored on the same directory as the *defconfig*
	* To execute any BSP-layer change use the following command:
		````bash
		bitbake -f -c compile virtual/kernel && bitbake -f -c deploy virtual/kernel
		````
8. Step: **Pre-install additional tools, like my *rstools* to interact with the FPGA configuration**
    * To pre-install addional components from this metal-layer it is only necessary to add the *Bitbake value* (*as shown in the tables above*) to the *local.conf* file
    * For instance to pre-install the ARM *Streamline* `gator` Server insert the following line to *local.conf* (*poky/build/conf/local.conf*)
    ```bash
	IMAGE_INSTALL:append = " gator "
	``` 
    * For installing all *rstools* use the following term
    ```bash
	IMAGE_INSTALL:append = " mselfpga readbridgesfpga resetfabricfpga statusfpga writebridgefpga writeconfigfpga writegpofpga readfgpipga "
	``` 
9. Step: **Optional: Configure BusyBox**
	* `BusyBox` is a Linux Software that can bring the typical Linux Console envivonment as simple In-/Output interface to enable a basic user interaction
	* The *core-image-minimal* image installs automatically `BusyBox` with a basic set of classical commands, such as `ls`, `cd`
	* With the following term it will be enabled to add additional commands to `BusyBox` 
	```bash
	bitbake -c menuconfig busybox
	```
    * If you want to save the `busybox`, the configuration file is written to a location as follows: `~/poky/build/tmp/work/cortexa9hf-neon-poky-linux-gnueabi/busybox/1.31.1-r0/busybox-1.31.1/`
10. Step: **Build the entire Yocto Project**
	* With this command the complete *Yocto Project* build process starts (executed inside *poky/build/*): 
	````bash
	bitbake core-image-minimal
	````
	* This process can taken some time
	* For an *Intel Arria 10 SoC-FPGA* the following start print should appear:
	![Alt text](doc/YoctoBuildHeader.jpg?raw=true "Yocto Project startup print")

	* This signaled that bitbake was able to decode the previously shown configuration 
11. Step: **Locate the final Kernel- and rootfs-File** 
	* After a successful build the final compressed Linux Kernel file and the *rootfs* "*tar.gz*"- archive is stored here: 
		* for an **Intel Cyclone V SoC-FPGA:**
		````txt
		poky/build/tmp/delopy/images/cyclone5/
		````
		* for an **Intel Arria 10 SX SoC-FPGA:**
		````txt
		poky/build/tmp/delopy/images/arria10/
		````
	* The rootFs-file is called: **core-image-minimal-cyclone5-<*Date Code*>.rootfs.tar.gz**
	* The Linux Kernel file is called: **zImage-<...+>.bin**
	* Be sure that the files are **not a Shortcut**!
	* In the case of an *Intel Cyclone V* SoC-FPGA, these two files are located here:
	![Alt text](doc/YocotoOutput.jpg?raw=true "Yocto Project output")

<br>

At this point a Linux for an *Intel SoC-FPGA* is generated. Unfortunately to boot this up also a *Linux Device Tree*, a primary- and secondary bootloader and for *Intel Arria* and *Intel Stratix* SoC-FPGAs two FPGA configuration files must be required.
<br>

# Continuation

### How to desgin the requiered bootloaders and the *DeviceTree* with Intel EDS ?
Inside my "*Mapping HPS Peripherels*, like *I²C* or *CAN*, over the *FPGA* fabric to *FPGA I/O* and using embedded Linux to control them"-guide I show that in details 
(see [here](https://github.com/robseb/HPS2FPGAmapping)).
<br>


### How to embedded Python pip packages to a Yocto Project?

I also wrote a python script to **pre-install Python pip (PyPI)- Packages within a final Yocto Project Linux Image** automatically 
(see [here](https://github.com/robseb/PiP2Bitbake)).
<br>

### How to bring the output files to a bootable image?

![Alt text](doc/BuildSystemHead.png?raw=true "Symbol of the build system")
**Build System: Use your *Intel Quartus Prime* FPGA project to create your own *rsyocto* with your FPGA Configuration**
___

I designed a Python script that can automate the boot image desgin with a specifiable partition table.
It can generate a bootable image file with Kernel-,bootloader- and user-files. With the flexibility of this script it is compatible with *Intel* SoC-EDS **build flow** for example it can pre-install FPGA configuration files.   
Tools like "rufus" can write for instance a SD-card to enable the booting of a Linux Distribution.
(see [here LinuxBootImageGenerator](https://github.com/robseb/LinuxBootImageGenerator)).
 
The ***rsyocto* build system** can use the information provided by the *Intel Quartus Prime* FPGA project to compile and configure the bootloader (*u-boot*) to boot up an embedded Linux and to configure the FPGA Fabric with the *Intel Quartus Prime FPGA project*. The **build system** changes the rootfs of the embedded Linux und uses XML-files for configuration to automate every essential step to achieve a good experience of a modern Linux Distribution. 
**It can directly use output files of the Yocto Project to generate a custom bootable Linux Distribution for Intel Cylone V- and Intel Arria 10 SX SoC-FPGAs.**
Please follow my [**detailed guide**](https://github.com/robseb/rsyocto/blob/rsYocto-1.042/doc/guides/9_customYoctoVersions.md). 


<br>

# Author
* *[rsyocto GmbH & Co. KG](https://rsyocto.com/)*; **Robin Sebastian,M.Sc. [(LinkedIn)](https://www.linkedin.com/in/robin-sebastian-a5080220a)**

**For commercial users, please visit the *rsyocto* embedded service provider website:** 
[**rsyocto.com**](https://rsyocto.com/)


[![Gitter](https://badges.gitter.im/rsyocto/community.svg)](https://gitter.im/rsyocto/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Email me!](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](mailto:git@robseb.de)

[![GitHub stars](https://img.shields.io/github/stars/robseb/meta-intelfpga?style=social)](https://GitHub.com/robseb/meta-altera/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/robseb/meta-intelfpga?style=social)](https://github.com/robseb/meta-altera/watchers)
[![GitHub followers](https://img.shields.io/github/followers/robseb?style=social)](https://github.com/robseb)
