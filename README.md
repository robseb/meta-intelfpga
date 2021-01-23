![GitHub](https://img.shields.io/static/v1?label=Plattform&message=Intel+SoC-FPGA&color=blue)
![GitHub](https://img.shields.io/static/v1?label=Yocto+Project+Releases&message=Warrior,Zeus,Dunfell,Gatesgarth,&color=darkgreen)
![GitHub](https://img.shields.io/github/license/robseb/meta-intelfpga)
<br>

# BSP meta-layer for Intel (*ALTERA*) SoC-FPGAS (*SoCFPGAs*) and the *Yocto Project* 

**With this layer the board support package (BSP) for *ARM* based *Intel (ALTERA) SoC-FPGAs (SoCFPGA)* is added to the *Yocto Project*.**

Usually the *Yocto Project* can generate all required components (rootfs, *device tree*, bootloaders,...) to boot up a final embedded Linux. But this is not compatible with [Intel's Boot flow](https://www.intel.com/content/dam/www/programmable/us/en/pdfs/literature/an/an709.pdf).
This Bootflow uses the Intel *Embedded Design Suite* (*EDS*) to build the device tree and all necessary bootloaders. 

For that reason, I designed a version that is compatible with *Intel's* development tools.  
This includes the board specific *u-boot-* and device tree-generation and the support for only the *.tar.gz*-file type for the *rootFs*. 

I used this layer to build [*rsYocto*](https://github.com/robseb/rsyocto), an open source embedded Linux System for Intel SoC-FPGAs, by me own. 
 

## Supported Device families

| **Device Family** | **Architecture** | **Machine Name**
|:--|:--|:--|
| Intel (*ALTERA*) **Cylone V** | *ARMv7A* | *MACHINE ="cyclone5"*
| Intel (*ALTERA*) **Arria V**  | *ARMv7A* | *MACHINE ="arria5"*
| Intel (*ALTERA*) **Arria 10** | *ARMv7A* | *MACHINE ="arria10"*
| Intel (*ALTERA*) **Stratix 10** | *ARMv8A* | *MACHINE ="stratix10"*
| Intel (*ALTERA*) **Agilex** | *ARMv8A* | *MACHINE ="agilex"*

## Linux Kernel Types

| **Linux Version Name** | **Version Type** | **Supported Linux Kernel Versions** 
|:--|:--|:--|
| *"linux-altera"* | **Regular Linux Version** |  `5.8`, `5.9`
| *"linux-altera-ltsi"* | **Long term stable Linux Version (LTS)** | `4.14.130`,`5.4.74`
| *"linux-altera-ltsi-rt"* | **Long term stable Linux Version (LTS) with real time support** | `4.14.126`

**The Linux Kernel source code is available on this official [Intel (*ALTERA*) repository](https://github.com/altera-opensource/linux-socfpga)**. 


## Getting started with the *Yocto Project* and usage of this BSP-layer

The following step by step guide shows how to use this layer to build a Yocto-based Linux System for an Intel SoC-FPGAs:
1. Step: **Install the latest Version of the *Yocto Project***
	* As a Building machine use regular *Ubuntu-Linux* **18.04 LTS** or **CentOS 7** running as a *Virtual Machine* (VM)
	* Required components for the *Yocto Project* with **Ubuntu Linux**:
		````bash
		sudo apt-get install gawk wget \
        git diffstat unzip texinfo gcc-multilib build-essential \
        chrpath socat xterm libsdl2-image-2.0-0 u-boot-tools \
        python3 python3-pip python3-pexpect \
        python3-git python3-jinja2 libncurses-dev
		````
	* Required components for the *Yocto Project* with **CentOS 7 Linux**:
		````bash
        sudo yum groupinstall "Development tools"
		sudo yum install -y epel-release
        sudo yum makecache
        sudo yum install -y gawk make wget tar bzip2 gzip python3 unzip perl patch \
        diffutils diffstat git cpp gcc gcc-c++ glibc-devel texinfo chrpath socat \
        perl-Data-Dumper perl-Text-ParseWords perl-Thread-Queue python36-pip xz \
        which SDL-devel xterm
        sudo pip3 install GitPython jinja2 
		````
    * (*Only for CentOS 7:*) Install *tar* Version *1.28* manually since only version *1.26* is available on *CentOS 7*
        ````bash
        cd ~
        wget http://ftp.gnu.org/gnu/tar/tar-1.28.tar.gz 
        tar xf tar-1.28.tar.gz
        cd tar-1.28
        ./configure  --prefix=/usr/local
        make
        cd ..
        sudo rm -r tar-1.28.tar.gz 
        export set PATH=~/tar-1.28/src:$PATH
        ````
        * Check your *git* version (*it should be 2.41+*)
            ````bash
            git --version
            ````
	 * (*Only for CentOS 7:*) Install the latest *git* version to prevent error with bitbake
        ````bash
        
        sudo yum remove git*
        sudo yum -y install https://packages.endpoint.com/rhel/7/os/x86_64/endpoint-repo-1.7-1.x86_64.rpm
		sudo yum install -y git
        ````
        * Check your *tar* version
            ````bash
            tar --version
            ````
			
	* Install the *Yocto Project* itself in Release *3.1 "Dunfell"*
		````bash
		cd && git clone -b dunfell git://git.yoctoproject.org/poky.git
		````
	* Install the *Yocto Project* itself in Release *3.2 "Gatesgarth"*
		````bash
		cd && git clone -b gatesgarth git://git.yoctoproject.org/poky.git
		````
	* Ubdate the build tools (e.g *gcc*) to the requiered version for bitbake
		````bash
		cd poky/scripts && ./install-buildtools && cd  ..
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
	* The repeatment of this bitbkake command do not interact the choosen configuration 
	* The script should create the folder: "/build"

4. Step: **Add this BSP-layer to your Yocto Project solution**
	* Open the **"bblayers.conf"**-file *(poky/build/conf)* with a text editor for example with *MS Visual Studio Code*:
		````bash 
		code conf/bblayers.conf
		````
	* At following line to this file to include the BSP-layer:
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
	* **Select your Intel SoC-FPGA family** by adding the value **"MACHINE"** this configuration file
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
			PREFERRED_PROVIDER_virtual/kernel = "linux-altera-ltsi"
			````
	* **Select the Linux Kernel Version**
	 	* With following code line it is possible to select the preferred Linux Kernel Version (here with *Version 5.8*)
			````bibtabe
			PREFERRED_VERSION_linux-altera = "5.8%"
			````
		* Alternatively, to select the *Long term stable Linux Version* (*LTS*) 5.4.74
			````bibtabe
			PREFERRED_VERSION_linux-altera = "5.4.74%"
			````
		* All supported Linux Kernel versions are listed above
	* **Choosing Toolchain Versions**
		* The following lines select the GCC and SDK Version:
			````bibtabe
			GCCVERSION = "linaro-4.9"
			SDKGCCVERSION = "linaro-4.9"
			````
		*Add this two lines to the **"local.conf"**-file independent of your machine choose 
 	* **Select the used CPU Version**
		* For an Dual Core Intel (ALTERA) **Cyclone V**, **Arria V** or **Arria 10** add the following line to the **"local.conf"**-file:
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
	* To configure the Linux property for a specific device family it is necessary to change the Linux Kernel configuration
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

		* Here it is possible to change any kernel settings, ARM-Platform specific settings or enable or disable some peripheral components
        * The *menueconfig* configuration will be stored on the same direcotory as the *defconfig*
	* To execute any BSP-layer change use following command:
		````bash
		bitbake -f -c compile virtual/kernel && bitbake -f -c deploy virtual/kernel
		````
8. Step: **Build the entire Yocto Project**
	* With this command the complete *Yocto Project* build process starts (executed inside *poky/build/*): 
	````bash
	bitbake core-image-minimal
	````
	* This process can taken some time
	* For an *Intel Arria 10 SoC-FPGA* following start print should appear:
	![Alt text](doc/YoctoBuildHeader.jpg?raw=true "Yocto Project startup print")
	* This signaled that bitbake was able to decode the previously shown configuration 
9. Step: **Locate the final Kernel- and rootFs-File** 
	* After a successful build the final compressed Linux Kernel file and the *rootfs* "*tar.gz*"- archive is stored here: 
		* for an **Intel Cyclone V:**
		````txt
		poky/build/tmp/delopy/images/cyclone5/
		````
		* for an **Intel Arria 10:**
		````txt
		poky/build/tmp/delopy/images/arria10/
		````
	* The rootFs-file is called: **core-image-minimal-cyclone5-<*Date Code*>.rootfs.tar.gz**
	* The Linux Kernel file is called: **zImage-<*...+>.bin**
	* Be sure that the files are **not a Shortcut**!
	* In the case of an Intel Cyclone V, these two files are located here:
	![Alt text](doc/YocotoOutput.jpg?raw=true "Yocto Project output")
<br>

At this point a Linux for an *Intel SoC-FPGA* is generated. Unfortunately to boot this up also an device tree, a primary- and secondary bootloader and for Intel Arria and Stratix two FPGA configuration files must be required.
<br>

# Continuation

### How to desgin the requiered bootloaders and the *DeviceTree* with Intel EDS ?
Inside my "*Mapping HPS Peripherals*, like *I²C* or *CAN*, over the *FPGA* fabric to *FPGA I/O* and using embedded Linux to control them"-guide I show that in details 
(see [here](https://github.com/robseb/HPS2FPGAmapping)).
<br>

### How to access the FPGA-Manager?

For accessing the FPGA-Manager or to execute shell scripts at boot up you can use my [**meta-rstools**](https://github.com/robseb/meta-rstools)-layer.
<br>

### How to embedded Python pip packages to a Yocto Project?

I also wrote a python script to **pre-install Python pip (PyPI)- Packages within a final Yocto Project Linux Image** automatically 
(see [here](https://github.com/robseb/PiP2Bitbake)).
<br>

### How to bring the output files to a bootable image?

I desigend a Python script that can automate the boot image desgin with a specifiable partition table.
It can generate an bootable image file with Kernel-,bootloader- and user-files. With the flexibility of this script it is compatible with *Intel* EDS build flow for example it can pre-install FPGA configuration files.   
Tools like "rufus" can write for instance a SD-card to enable the booting of a Linux Distribution.
(see [here LinuxBootImageGenerator](https://github.com/robseb/LinuxBootImageGenerator))
<br>

# Credits & Contribution
Big thanks to [**Khem Raj**](https://github.com/kraj) for his maintaince work!
<br>


# Author

**Robin Sebastian**

*meta-intelfpga* and [*rsyocto*](https://github.com/robseb/rsyocto) are projects, that I have fully developed on my own.
No companies are involved in my projects.
I’m recently graduated as a master in electrical engineering with the major embedded systems (*M. Sc.*).

I'm open for cooperations as a freelancer to realize your specific requirements.
Otherwise, I‘m looking for an interesting full time job offer to share and deepen my shown skills.

**[Github sponsoring is welcome.](https://github.com/sponsors/robseb)**


[![Gitter](https://badges.gitter.im/rsyocto/community.svg)](https://gitter.im/rsyocto/community?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)
[![Email me!](https://img.shields.io/badge/Ask%20me-anything-1abc9c.svg)](mailto:git@robseb.de)

[![GitHub stars](https://img.shields.io/github/stars/robseb/meta-intelfpga?style=social)](https://GitHub.com/robseb/meta-altera/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/robseb/meta-intelfpga?style=social)](https://github.com/robseb/meta-altera/watchers)
[![GitHub followers](https://img.shields.io/github/followers/robseb?style=social)](https://github.com/robseb)
