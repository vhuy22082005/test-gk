package com.example.test_gk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.test_gk.databinding.FragmentItemListBinding;

import java.util.ArrayList;
import java.util.List;

public class ItemFragment extends Fragment {

    private static final String ARG_LAYOUT_TYPE = "layout_type";

    public static final int LAYOUT_LINEAR = 0;
    public static final int LAYOUT_GRID = 1;
    public static final int LAYOUT_STAGGERED = 2;

    private FragmentItemListBinding binding;
    private int layoutType = LAYOUT_LINEAR;

    public static ItemFragment newInstance(int layoutType) {
        ItemFragment fragment = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_LAYOUT_TYPE, layoutType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            layoutType = getArguments().getInt(ARG_LAYOUT_TYPE, LAYOUT_LINEAR);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentItemListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Item> sampleItems = getSampleData();
        RecyclerView recyclerView = binding.recyclerView;

        RecyclerView.LayoutManager layoutManager;
        ItemAdapter adapter;

        switch (layoutType) {
            case LAYOUT_GRID:
                layoutManager = new GridLayoutManager(getContext(), 2);
                adapter = new ItemAdapter(sampleItems, ItemAdapter.TYPE_GRID);
                break;
            case LAYOUT_STAGGERED:
                layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                adapter = new ItemAdapter(sampleItems, ItemAdapter.TYPE_GRID);
                break;
            case LAYOUT_LINEAR:
            default:
                layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                adapter = new ItemAdapter(sampleItems, ItemAdapter.TYPE_LINEAR);
                break;
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<Item> getSampleData() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "Smartphone Pro Max", "Điện thoại thông minh camera 108MP, màn hình 120Hz mượt mà.", "22.990.000 đ", "Điện thoại", R.drawable.ic_phone, 120));
        list.add(new Item(2, "Laptop Gaming Ultra", "Laptop cấu hình khủng Chip i9, VGA RTX 4080 cho game thủ.", "35.500.000 đ", "Laptop", R.drawable.ic_laptop, 180));
        list.add(new Item(3, "Máy Ảnh Mirrorless", "Máy ảnh bắt khoảnh khắc siêu nét, quay video 4K sắc nét.", "18.400.000 đ", "Máy ảnh", R.drawable.ic_camera, 140));
        list.add(new Item(4, "Đồng Hồ SmartWatch", "Theo dõi sức khỏe, đo nhịp tim và giấc ngủ 24/7.", "5.200.000 đ", "Phụ kiện", R.drawable.ic_watch, 110));
        list.add(new Item(5, "Tai Nghe Anti-Noise", "Tai nghe chống ồn chủ động, âm thanh Hi-Res sống động.", "4.150.000 đ", "Âm thanh", R.drawable.ic_headphones, 160));
        list.add(new Item(6, "Máy Tính Bảng Tab S", "Màn hình OLED 11 inch, hỗ trợ bút cảm ứng mượt mà.", "14.800.000 đ", "Tablet", R.drawable.ic_tablet, 130));
        list.add(new Item(7, "Loa Bluetooth Bass Boost", "Loa di động chống nước IP67, pin trâu 20 giờ liên tục.", "2.900.000 đ", "Âm thanh", R.drawable.ic_speaker, 150));
        list.add(new Item(8, "Smart TV 4K 65 inch", "Truyền hình thông minh hình ảnh sắc nét, âm thanh vòm.", "16.700.000 đ", "Gia dụng", R.drawable.ic_tv, 170));
        list.add(new Item(9, "Smartphone Lite Edition", "Thiết kế mỏng nhẹ, pin dung lượng cao 5000mAh.", "8.500.000 đ", "Điện thoại", R.drawable.ic_phone, 120));
        list.add(new Item(10, "Laptop Office Thin", "Laptop văn phòng mỏng nhẹ, mượt mà các tác vụ làm việc.", "12.900.000 đ", "Laptop", R.drawable.ic_laptop, 140));
        return list;
    }
}