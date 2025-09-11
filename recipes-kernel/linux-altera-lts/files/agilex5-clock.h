#ifndef _DT_BINDINGS_CLK_AGILEX5_H
#define _DT_BINDINGS_CLK_AGILEX5_H

/* Intel Agilex 5 Clock definitions */

/* Main PLL clocks */
#define AGILEX5_CLK_MAIN_PLL		0
#define AGILEX5_CLK_MPU			1
#define AGILEX5_CLK_MPU_L2RAM		2
#define AGILEX5_CLK_MPU_PERIPH		3
#define AGILEX5_CLK_L4_MAIN		4
#define AGILEX5_CLK_L4_MP		5
#define AGILEX5_CLK_L4_SP		6
#define AGILEX5_CLK_L4_SYS		7

/* Peripheral PLL clocks */
#define AGILEX5_CLK_PERI_PLL		8
#define AGILEX5_CLK_EMAC0		9
#define AGILEX5_CLK_EMAC1		10
#define AGILEX5_CLK_EMAC2		11
#define AGILEX5_CLK_USB			12
#define AGILEX5_CLK_QSPI		13
#define AGILEX5_CLK_SDMMC		14

/* NoC PLL clocks */
#define AGILEX5_CLK_NOC_PLL		15
#define AGILEX5_CLK_NOC			16

/* Other clocks */
#define AGILEX5_CLK_OSC1		17
#define AGILEX5_CLK_OSC2		18
#define AGILEX5_CLK_F2S_FREE		19
#define AGILEX5_CLK_CS_TIMER		20

#define AGILEX5_NUM_CLKS		21

#endif /* _DT_BINDINGS_CLK_AGILEX5_H */