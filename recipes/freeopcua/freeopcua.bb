DESCRIPTION = "Freeopcua server"

DEPENDS += " libxml2 boost python libtool"


LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRCREV= "420305bbb904e7f00883dc067f2b3d2cdde2b9d1"
SRC_URI = "git://github.com/treww/freeopcua"
S = "${WORKDIR}/git"
PR = "r0"


INITSCRIPT_NAME = "opcuaserver"
INIT_SCRIPT_PARAM = "defaults"


inherit autotools update-rc.d

FILES_${PN} += "/etc/init.d/freeopcua"

EXTRA_OECONF = " --disable-python-bindings --disable-unit-tests"

do_install_append () {
  chmod a+x ${D}${sysconfdir}/init.d/opcuaserver
  install -d ${D}${localstatedir}
  install -d ${D}${localstatedir}/log
  install -d ${D}${localstatedir}/log/opcua
}

