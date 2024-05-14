package com.sky.mapper;

import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询套餐id
     * @param
     * @return
     */

    List<Long> getSetmealIdByDishId(List<Long> dishIds);

    /**
     * 新增菜品套餐关联
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据setmealid查询菜品套餐表
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id =#{setmealId} ")
    List<SetmealDish> getBySetmealId(Long setmealId);

    /**
     * 根据setmealId删除套餐--菜品表
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id =#{setmealId}")
    void deleteBySetmealId(Long setmealId);

    /**
     * 根据套餐id查询该套餐下的菜品
     * @return
     */
    List<Dish> getDishBySetmealId(Long setmealId);
}