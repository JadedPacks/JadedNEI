/*
Why is this here?
Simply because, java will not compile with the source of the obfuscated MineTweaker, as it sees ItemStack as class 'ye'
- Developaws
*/

package stanhebben.minetweaker.api.value;

import net.minecraft.item.ItemStack;

public final class TweakerItem extends TweakerValue {
	private final ItemStack value;

	public TweakerItem(ItemStack value) {
		this.value = value;
	}

	public ItemStack make() {
		return value;
	}

	@Override
	public String toString() {
		return null;
	}
}