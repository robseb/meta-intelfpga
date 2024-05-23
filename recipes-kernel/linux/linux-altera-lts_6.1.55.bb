## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2024

SUMMARY = "Linux Kernel 6.1.55 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.1.55 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "6.1.55"
LINUX_VERSION_SUFFIX = "-lts"

# Note:  Fri Nov 17 08:13:36 2023 -0500
SRCREV = "57cf7f3b7f73c72123f7d29591297758f645727d"
SRCREV:machine:cyclone5 ?= "57cf7f3b7f73c72123f7d29591297758f645727d"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"