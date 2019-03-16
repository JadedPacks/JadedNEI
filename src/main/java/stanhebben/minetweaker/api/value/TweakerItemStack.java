/*
Why is this here?
Simply because, java will not compile with the source of the obfuscated MineTweaker, as it sees ItemStack as class 'ye'
- Developaws
*/

package stanhebben.minetweaker.api.value;

import net.minecraft.item.ItemStack;

public final class TweakerItemStack extends TweakerValue {
	private final ItemStack value;

	public TweakerItemStack(ItemStack value) {
		this.value = value;
	}

	public ItemStack get() {
		return value;
	}

	public String getDisplayName() {
		return value.getDisplayName();
	}

	@Override
	public String toString() {
		return null;
	}
}