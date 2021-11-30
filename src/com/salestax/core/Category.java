package com.salestax.core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author User
 *
 */
public interface Category {
    
    public String getName();

    
    public default Category getParent() {
        return null;
    }

    public default Collection<Category> getChildren() {
       return null;
    }
    
    public boolean addChildCategory(Category category);

//    public boolean contains(Category category);
    
    public default boolean hasParent() {
        return Objects.nonNull(getParent());
    }
    
    public default boolean isChildOf(Category category) {
        if(Objects.isNull(category.getChildren())) {
            return false;
        }
        return category.getChildren().contains(category);
    }
    
//    enum BOOK implements Category {
//        BOOK;
//
//        @Override
//        public String getName() {
//            return "BOOK";
//        }
//
//        @Override
//        public boolean contains(Category category) {
//            {
//                if (this == category) {
//                    return true;
//                }
//
//                for (Category cat : getChildren()) {
//                    if (cat.contains(category)) {
//                        return true;
//                    }
//                }
//
//                return false;
//            }
//        }
//    }
//    
//    /**
//     * @author User
//     *
//     */
//    enum FOOD implements Category {
//        FOOD;
//
//        @Override
//        public String getName() {
//            return "FOOD";
//        }
//
//        @Override
//        public boolean contains(Category category) {
//            // TODO Auto-generated method stub
//            return false;
//        }
//    }

}
