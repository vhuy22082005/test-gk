package com.example.test_gk;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_gk.databinding.ItemGridBinding;
import com.example.test_gk.databinding.ItemLinearBinding;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_LINEAR = 0;
    public static final int TYPE_GRID = 1;

    private final List<Item> itemList;
    private final int viewTypeMode;

    public ItemAdapter(List<Item> itemList, int viewTypeMode) {
        this.itemList = itemList;
        this.viewTypeMode = viewTypeMode;
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypeMode;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_LINEAR) {
            ItemLinearBinding binding = ItemLinearBinding.inflate(inflater, parent, false);
            return new LinearViewHolder(binding);
        } else {
            ItemGridBinding binding = ItemGridBinding.inflate(inflater, parent, false);
            return new GridViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Item item = itemList.get(position);
        if (holder instanceof LinearViewHolder) {
            ((LinearViewHolder) holder).bind(item);
        } else if (holder instanceof GridViewHolder) {
            ((GridViewHolder) holder).bind(item);
        }
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    static class LinearViewHolder extends RecyclerView.ViewHolder {
        private final ItemLinearBinding binding;

        public LinearViewHolder(@NonNull ItemLinearBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Item item) {
            binding.tvTitle.setText(item.getTitle());
            binding.tvDescription.setText(item.getDescription());
            binding.tvCategory.setText(item.getCategory());
            binding.tvPrice.setText(item.getPrice());
            binding.imgItem.setImageResource(item.getImageResId());

            binding.getRoot().setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Đã chọn: " + item.getTitle(), Toast.LENGTH_SHORT).show()
            );
        }
    }

    static class GridViewHolder extends RecyclerView.ViewHolder {
        private final ItemGridBinding binding;

        public GridViewHolder(@NonNull ItemGridBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Item item) {
            binding.tvTitle.setText(item.getTitle());
            binding.tvDescription.setText(item.getDescription());
            binding.tvCategory.setText(item.getCategory());
            binding.tvPrice.setText(item.getPrice());
            binding.imgItem.setImageResource(item.getImageResId());

            // Thay đổi chiều cao hình ảnh cho Staggered Grid để tạo hiệu ứng bất đối xứng
            if (item.getItemHeightDp() > 0) {
                float density = binding.getRoot().getContext().getResources().getDisplayMetrics().density;
                int heightPx = (int) (item.getItemHeightDp() * density);
                ViewGroup.LayoutParams params = binding.imgContainer.getLayoutParams();
                params.height = heightPx;
                binding.imgContainer.setLayoutParams(params);
            }

            binding.getRoot().setOnClickListener(v ->
                    Toast.makeText(v.getContext(), "Đã chọn: " + item.getTitle(), Toast.LENGTH_SHORT).show()
            );
        }
    }
}