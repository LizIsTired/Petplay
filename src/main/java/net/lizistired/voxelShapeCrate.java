package net.lizistired;

import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;

public class voxelShapeCrate {
    public static VoxelShape makeShapeClosed() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(-0.25, 0, -0.25, 1.25, 0.0625, 1.25),
                VoxelShapes.cuboid(-0.25, 1.6875, -0.25, 1.25, 1.75, 1.25),
                VoxelShapes.cuboid(-0.1875, 0.0625, -0.1875, 1.1875, 0.125, 1.1875),
                VoxelShapes.cuboid(-0.1875, 0.1875, 1.1875, -0.0625, 1.5625, 1.25),
                VoxelShapes.cuboid(-0.1875, 0.0625, 1.1875, 1.1875, 0.1875, 1.25),
                VoxelShapes.cuboid(-0.1875, 1.5625, 1.1875, 1.1875, 1.6875, 1.25),
                VoxelShapes.cuboid(-0.25, 0.0625, -0.25, -0.1875, 1.6875, -0.1875),
                VoxelShapes.cuboid(0, 0.1875, 1.1875, 0.0625, 1.5625, 1.25),
                VoxelShapes.cuboid(0.1875, 0.1875, 1.1875, 0.25, 1.5625, 1.25),
                VoxelShapes.cuboid(0.375, 0.1875, 1.1875, 0.4375, 1.5625, 1.25),
                VoxelShapes.cuboid(0.75, 0.1875, 1.1875, 0.8125, 1.5625, 1.25),
                VoxelShapes.cuboid(0.9375, 0.1875, 1.1875, 1, 1.5625, 1.25),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.03125, -0.1875, 1.6875, 0.09375),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.21875, -0.1875, 1.6875, 0.28125),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.40625, -0.1875, 1.6875, 0.46875),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.59375, -0.1875, 1.6875, 0.65625),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.78125, -0.1875, 1.6875, 0.84375),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.96875, -0.1875, 1.6875, 1.03125),
                VoxelShapes.cuboid(1.0625, 0.1875, 1.1875, 1.1875, 1.5625, 1.25),
                VoxelShapes.cuboid(-0.25, 0.0625, 1.1875, -0.1875, 1.6875, 1.25),
                VoxelShapes.cuboid(1.1875, 0.0625, 1.1875, 1.25, 1.6875, 1.25),
                VoxelShapes.cuboid(1.1875, 0.0625, -0.25, 1.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0, 0.0625, -0.25, 0.0625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.1875, 0.0625, -0.25, 0.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.375, 0.0625, -0.25, 0.4375, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.5625, 0.0625, -0.25, 0.625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.75, 0.0625, -0.25, 0.8125, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.9375, 0.0625, -0.25, 1, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.5625, 0.1875, 1.1875, 0.625, 1.5625, 1.25),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.96875, 1.25, 1.6875, 1.03125),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.78125, 1.25, 1.6875, 0.84375),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.59375, 1.25, 1.6875, 0.65625),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.40625, 1.25, 1.6875, 0.46875),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.21875, 1.25, 1.6875, 0.28125),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.03125, 1.25, 1.6875, 0.09375),
                VoxelShapes.cuboid(0, 0.0625, -0.25, 0.0625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.1875, 0.0625, -0.25, 0.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.375, 0.0625, -0.25, 0.4375, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.5625, 0.0625, -0.25, 0.625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.75, 0.0625, -0.25, 0.8125, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.9375, 0.0625, -0.25, 1, 1.6875, -0.1875)
        );
    }
    public static VoxelShape makeShapeOpen() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(-0.25, 0, -0.25, 1.25, 0.0625, 1.25),
                VoxelShapes.cuboid(-0.25, 1.6875, -0.25, 1.25, 1.75, 1.25),
                VoxelShapes.cuboid(-0.1875, 0.0625, -0.1875, 1.1875, 0.125, 1.1875),
                VoxelShapes.cuboid(-0.25, 0.0625, -0.25, -0.1875, 1.6875, -0.1875),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.03125, -0.1875, 1.6875, 0.09375),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.21875, -0.1875, 1.6875, 0.28125),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.40625, -0.1875, 1.6875, 0.46875),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.59375, -0.1875, 1.6875, 0.65625),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.78125, -0.1875, 1.6875, 0.84375),
                VoxelShapes.cuboid(-0.25, 0.0625, 0.96875, -0.1875, 1.6875, 1.03125),
                VoxelShapes.cuboid(-0.25, 0.0625, 1.1875, -0.1875, 1.6875, 1.25),
                VoxelShapes.cuboid(1.1875, 0.0625, 1.1875, 1.25, 1.6875, 1.25),
                VoxelShapes.cuboid(1.1875, 0.0625, -0.25, 1.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0, 0.0625, -0.25, 0.0625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.1875, 0.0625, -0.25, 0.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.375, 0.0625, -0.25, 0.4375, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.5625, 0.0625, -0.25, 0.625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.75, 0.0625, -0.25, 0.8125, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.9375, 0.0625, -0.25, 1, 1.6875, -0.1875),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.96875, 1.25, 1.6875, 1.03125),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.78125, 1.25, 1.6875, 0.84375),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.59375, 1.25, 1.6875, 0.65625),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.40625, 1.25, 1.6875, 0.46875),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.21875, 1.25, 1.6875, 0.28125),
                VoxelShapes.cuboid(1.1875, 0.0625, 0.03125, 1.25, 1.6875, 0.09375),
                VoxelShapes.cuboid(0, 0.0625, -0.25, 0.0625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.1875, 0.0625, -0.25, 0.25, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.375, 0.0625, -0.25, 0.4375, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.5625, 0.0625, -0.25, 0.625, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.75, 0.0625, -0.25, 0.8125, 1.6875, -0.1875),
                VoxelShapes.cuboid(0.9375, 0.0625, -0.25, 1, 1.6875, -0.1875)
        );
    }
}