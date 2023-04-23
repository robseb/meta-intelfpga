# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package plotly into a Yocto Project"
HOMEPAGE ="https://pypi.org/project/pip"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c7b311a6fbf8f1e2f22c16e2ad556f98"

PYPI_PACKAGE = "plotly"

inherit pypi setuptools3

SRC_URI[sha256sum] = "90ee9a1fee0dda30e2830e129855081ea17bd1b06a553a62b62de15caff1a219"

FILES:${PN} += " \
    ${datadir}/* \
    ${prefix}/etc/jupyter/nbconfig/notebook.d/jupyterlab-plotly.json \
    "