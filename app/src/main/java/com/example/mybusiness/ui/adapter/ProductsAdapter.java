package com.example.mybusiness.ui.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.example.mybusiness.R;
import com.example.mybusiness.db.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<Product> products;

    public ProductsAdapter(){
        products = new ArrayList<>();
    }

    public void setData(List<Product> products){
        this.products.clear();
        this.products.addAll(products);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new com.example.mybusiness.ui.adapter.ProductsAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemView;
        private TextView productName;
        private TextView productCode;
        private TextView productStock;
        private TextView productPrice;
        private TextView productCategory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            productCode = itemView.findViewById(R.id.txt_codigo);
            productName = itemView.findViewById(R.id.txt_nombre);
            productStock = itemView.findViewById(R.id.txt_stock);
            productPrice = itemView.findViewById(R.id.txt_precio);
            productCategory = itemView.findViewById(R.id.txt_categoria);
        }

        public void bind(Product product){
            productCode.setText(product.getCodigo());
            productName.setText(product.getNombre());
            productStock.setText(product.getCantidad()+"");
            productPrice.setText("$"+product.getPrecioVenta());
            productCategory.setText(product.getCategoria()+"");
            Log.w("ID", product.getId()+"");
            itemView.setOnClickListener( v ->{
                Bundle extras = new Bundle();
                extras.putInt(CreateProductFragment.ACTION,CreateProductFragment.ACTION_EDIT);
                extras.putString(CreateProductFragment.DATA, new Gson().toJson(product));
                Navigation.findNavController(itemView).navigate(R.id.open_create_product,extras);
            });
        }
    }
}
