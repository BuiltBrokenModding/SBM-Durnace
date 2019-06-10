package com.builtbroken.durnace.content.inv;

import com.builtbroken.durnace.content.TileDurnace;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RangedWrapper;

/**
 * Created by Dark(DarkGuardsman, Robert) on 6/9/2019.
 */
public class InventoryDuranceBottom extends RangedWrapper
{
    private TileDurnace tileDurnace;

    public InventoryDuranceBottom(TileDurnace tileDurnace, ItemStackHandler inventory)
    {
        super(inventory, 1, 3);
        this.tileDurnace = tileDurnace;
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate)
    {
        ItemStack stack = getStackInSlot(slot);
        if (canExtractItem(slot, stack))
        {
            return super.extractItem(slot, amount, simulate);
        }
        return ItemStack.EMPTY;
    }


    public boolean canExtractItem(int index, ItemStack stack)
    {
        if (index == 0) //internal slot ID (1 -> 0)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }
        return true;
    }
}
