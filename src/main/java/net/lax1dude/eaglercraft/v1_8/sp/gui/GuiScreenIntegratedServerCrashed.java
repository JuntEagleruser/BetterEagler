package net.lax1dude.eaglercraft.v1_8.sp.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;

/**
 * Copyright (c) 2023-2024 lax1dude. All Rights Reserved.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 */
public class GuiScreenIntegratedServerCrashed extends GuiScreen {

	private GuiScreen mainmenu;
	private String crashReport;

	public GuiScreenIntegratedServerCrashed(GuiScreen mainmenu, String crashReport) {
		this.mainmenu = mainmenu;
		this.crashReport = crashReport;
	}
	
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height - 50, I18n.format("singleplayer.crashed.continue")));
		ScaledResolution res = new ScaledResolution(mc);
		int i = res.getScaleFactor();
		CrashScreen.showCrashReportOverlay(crashReport, 90 * i, 60 * i, (width - 180) * i, (height - 130) * i);
	}
	
	public void onGuiClosed() {
		CrashScreen.hideCrashReportOverlay();
	}
	
	public void drawScreen(int par1, int par2, float par3) {
		this.drawDefaultBackground();

		this.drawCenteredString(fontRendererObj, I18n.format("singleplayer.crashed.title"), this.width / 2, 25, 0xFFAAAA);
		this.drawCenteredString(fontRendererObj, I18n.format("singleplayer.crashed.checkConsole"), this.width / 2, 40, 0xBBBBBB);

		super.drawScreen(par1, par2, par3);
	}

	protected void actionPerformed(GuiButton par1GuiButton) {
		if(par1GuiButton.id == 0) {
			this.mc.displayGuiScreen(mainmenu);
		}
	}
	
}