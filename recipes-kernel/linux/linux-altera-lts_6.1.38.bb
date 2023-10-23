## Robin Sebastian (https://github.com/robseb) (git@robseb.de) 2019-2023

SUMMARY = "Linux Kernel 6.1.38 LTS for Intel PSG (ALTERA) SoC-FPGAs"
DESCRIPTION = "Linux Kernel 6.1.38 LTS for Intel PSG (ALTERA) SoC-FPGAs" 

LINUX_VERSION = "6.1.38"
LINUX_VERSION_SUFFIX = "-lts"


# Note:  Tue Sep 26 04:14:15 2023 +0800
SRCREV = "21b5300ed5bd7bf2a8fe8ed2d4a1b1bb482f9303"
SRCREV:machine:cyclone5 ?= "21b5300ed5bd7bf2a8fe8ed2d4a1b1bb482f9303"

include linux-altera.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"





