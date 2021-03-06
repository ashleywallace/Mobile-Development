package org.flixel.plugin.flxbox2d.dynamics.joints;

import org.flixel.FlxU;
import org.flixel.plugin.flxbox2d.B2FlxB;
import org.flixel.plugin.flxbox2d.collision.shapes.B2FlxShape;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.joints.GearJoint;
import com.badlogic.gdx.physics.box2d.joints.GearJointDef;

/**
 * A gear joint is used to connect two joints together. Either joint can be a revolute 
 * or prismatic joint. You specify a gear ratio to bind the motions 
 * together: coordinate1 + ratio * coordinate2 = constant The ratio can be negative or positive. 
 * If one joint is a revolute joint and the other joint is a prismatic joint, then the ratio 
 * will have units of length or units of 1/length. 
 * 
 * @author Ka Wing Chin
 */
public class B2FlxGearJoint extends B2FlxJoint
{
	/**
	 * Creates a gear joint.
	 * @param spriteA	The first body.
	 * @param spriteB	The second body.
	 * @param jointDef	The joint definition.
	 */
	public B2FlxGearJoint(B2FlxShape spriteA, B2FlxShape spriteB, GearJointDef jointDef)
	{
		super(spriteA, spriteB, jointDef);
		
	}
	
	/**
	 * Creates a gear joint.
	 * @param spriteA	The first body.
	 * @param spriteB	The second body.
	 */
	public B2FlxGearJoint(B2FlxShape spriteA, B2FlxShape spriteB)
	{
		super(spriteA, spriteB, null);
	}
	
	/**
	 * Creates the jointDef.
	 */
	@Override
	protected void setupJointDef()
	{
		if(jointDef == null)
			jointDef = new GearJointDef();
		jointDef.bodyA = bodyA;
		jointDef.bodyB = bodyB;
	}
	
	/**
	 * Creates the joint.
	 * @return	This joint. Handy for chaining stuff together.
	 */
	@Override
	public B2FlxGearJoint create()
	{
		joint = B2FlxB.world.createJoint(jointDef);
		return this;
	}
	
	/**
	 * Set the ratio.
	 * @param ratio
	 * @return	This joint. Handy for chaining stuff together.
	 */
	public B2FlxGearJoint setRatio(float ratio)
	{
		((GearJointDef)jointDef).ratio = ratio;
		return this;
	}
	
	/**
	 * Set the first joint. It must be either a revolute or prismatic joint.
	 * @param joint1	The joint that will be connected to this joint.
	 * @return	This joint. Handy for chaining stuff together.
	 */
	public B2FlxGearJoint setJoint1(Joint joint1)
	{		
		if(!FlxU.getClassName(joint1, true).equals("RevoluteJoint") && !FlxU.getClassName(joint1, true).equals("PrismaticJoint"))
			throw new Error("The joint must be either a revolute or prismatic joint!");
		((GearJointDef)jointDef).joint1 = joint1;
		return this;
	}
	
	/**
	 * Set the second joint. It must be either a revolute or prismatic joint.
	 * @param joint2	The joint that will be connected to this joint.
	 * @return	This joint. Handy for chaining stuff together.
	 */
	public B2FlxGearJoint setJoint2(Joint joint2)
	{
		if(!FlxU.getClassName(joint2, true).equals("RevoluteJoint") && !FlxU.getClassName(joint2, true).equals("PrismaticJoint"))
			throw new Error("The joint must be either a revolute or prismatic joint!");
		((GearJointDef)jointDef).joint2 = joint2;
		return this;
	}

	@Override
	public GearJoint getJoint(){return (GearJoint)joint;}
	@Override
	public B2FlxGearJoint setJointDef(JointDef jointDef){super.setJointDef(jointDef);return this;}	
	@Override
	public B2FlxGearJoint setBodyA(Body bodyA){super.setBodyA(bodyA);return this;}	
	@Override
	public B2FlxGearJoint setBodyB(Body bodyB){super.setBodyB(bodyB);return this;}	
	@Override
	public B2FlxGearJoint setAnchorA(Vector2 anchorA){super.setAnchorA(anchorA);return this;}	
	@Override
	public B2FlxGearJoint setAnchorB(Vector2 anchorB){super.setAnchorB(anchorB);return this;}	
	@Override
	public B2FlxGearJoint setCollideConnected(boolean collideConnected){super.setCollideConnected(collideConnected);return this;}
	@Override
	public B2FlxGearJoint setShowLine(boolean showLine){super.setShowLine(showLine);return this;}	
	@Override
	public B2FlxGearJoint setLineThickness(float lineThickness){super.setLineThickness(lineThickness);return this;}	
	@Override
	public B2FlxGearJoint setLineColor(int lineColor){super.setLineColor(lineColor);return this;}	
	@Override
	public B2FlxGearJoint setLineAlpha(float lineAlpha){super.setLineAlpha(lineAlpha);return this;}
}
