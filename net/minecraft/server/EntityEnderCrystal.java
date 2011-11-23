package net.minecraft.server;

public class EntityEnderCrystal extends Entity {

    public int a = 0;
    public int b;

    public EntityEnderCrystal(World world) {
        super(world);
        this.bc = true;
        this.b(2.0F, 2.0F);
        this.height = this.width / 2.0F;
        this.b = 5;
        this.a = this.random.nextInt(100000);
    }

    protected boolean g_() {
        return false;
    }

    protected void b() {
        this.datawatcher.a(8, Integer.valueOf(this.b));
    }

    public void w_() {
        this.lastX = this.locX;
        this.lastY = this.locY;
        this.lastZ = this.locZ;
        ++this.a;
        this.datawatcher.watch(8, Integer.valueOf(this.b));
        int i = MathHelper.floor(this.locX);
        int j = MathHelper.floor(this.locY);
        int k = MathHelper.floor(this.locZ);

        if (this.world.getTypeId(i, j, k) != Block.FIRE.id) {
            this.world.setTypeId(i, j, k, Block.FIRE.id);
        }
    }

    protected void b(NBTTagCompound nbttagcompound) {}

    protected void a(NBTTagCompound nbttagcompound) {}

    public boolean e_() {
        return true;
    }

    public boolean damageEntity(DamageSource damagesource, int i) {
        if (!this.dead && !this.world.isStatic) {
            this.b = 0;
            if (this.b <= 0) {
                if (!this.world.isStatic) {
                    this.die();
                    this.world.a((Entity) null, this.locX, this.locY, this.locZ, 6.0F);
                } else {
                    this.die();
                }
            }
        }

        return true;
    }
}