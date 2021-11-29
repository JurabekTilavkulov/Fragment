package com.example.uyishi_recycleview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleDragDrog extends ItemTouchHelper.Callback {

    private ItemTouchHelperDragRrog itemTouchHelperDragRrog;

    public RecycleDragDrog(ItemTouchHelperDragRrog itemTouchHelperDragRrog) {
        this.itemTouchHelperDragRrog = itemTouchHelperDragRrog;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragflag=ItemTouchHelper.UP | ItemTouchHelper.DOWN ;
        return makeMovementFlags(dragflag,0);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        itemTouchHelperDragRrog.onMoveSelected(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

    }
    interface ItemTouchHelperDragRrog{
        void onMoveSelected(int from, int to); // kochirish
        void onItemSelected(RecyclerView.ViewHolder viewHolder);  // rangi o'zgarish
        void onClearSelected(RecyclerView.ViewHolder viewHolder);
    }

    @Override
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
        if(actionState!=ItemTouchHelper.ACTION_STATE_IDLE){
            if(viewHolder instanceof ItemTouchHelperDragRrog){
                ItemTouchHelperDragRrog it= (ItemTouchHelperDragRrog) viewHolder;
               // itemTouchHelperDragRrog.onItemSelected(viewHolder1);
            }
        }
        super.onSelectedChanged(viewHolder, actionState);
    }

    @Override
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if(viewHolder instanceof ItemTouchHelperDragRrog){
            RecyclerView.ViewHolder viewHolder1=viewHolder;
            itemTouchHelperDragRrog.onClearSelected(viewHolder1);
        }
    }
}
